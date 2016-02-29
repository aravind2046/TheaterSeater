package com.seater.theater.serviceTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.stub;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.seater.theater.data.Auditorium;
import com.seater.theater.dataServices.TheaterSeaterDataServiceImpl;
import com.seater.theater.exception.TicketServiceException;
import com.seater.theater.json.SeatDetail;
import com.seater.theater.json.SeatHold;
import com.seater.theater.services.TheaterSeaterServiceImpl;
import com.seater.theater.testUtil.TSTestUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class TSConcurrentBookAlltheSeatsUsing10ThreadsTest implements Runnable{
	private static Auditorium auditorium =null;
	static{
	
	try {
		auditorium  = TSTestUtil.loadDataBase();
	} catch (TicketServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
	@Mock
	private TheaterSeaterDataServiceImpl theatreDSI;
	
	@InjectMocks
	private  static TheaterSeaterServiceImpl ticketService;

	@Before
	public void initializeMockito() throws Exception {
	
		MockitoAnnotations.initMocks(this);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void concurrentTest() throws InterruptedException{
		//This checks if 5 threads with each of 5  are executed , and the count of availability is check at the end
		stub(theatreDSI.getAuditoriumDetails()).toReturn(auditorium);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new TSConcurrentBookAlltheSeatsUsing10ThreadsTest();
           executor.execute(worker);
        }
        Thread.sleep(3000);
          }
	
public void run() {
	SeatHold seatsHeld = null;
	try {
		seatsHeld = ticketService.findAndHoldSeats(20, 1, 2, "aravind0106@gmail.com");
	} catch (TicketServiceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertNotNull(seatsHeld);
	String confCode = null;
	for(SeatDetail detail : seatsHeld.getSeatsHeld()){
		try {
			confCode= ticketService.reserveSeats(String.valueOf(detail.getLevelNumber())+String.valueOf(detail.getSeatNumber())+detail.getRowNumber(), "aravind0106@gmail.com");
		} catch (TicketServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(confCode);
		}
}
}
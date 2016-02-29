# TheaterSeater
WMTicketService


===========
HOW TO RUN
===========
1. Download the projects to your local machine
2. Go to the source folder
3. hit "mvn clean install"


==================
RESTAPI calls:
==================

1. GET
---------------
getNumOfSeatsAvail(int levelNum)
URI -->http://localhost:8080/TheaterSeaterWeb/rest/ticketService/numOfSeatsAvailOnLevel/{levelNum}
This will give the respone as : {"numOfAvailSeats":1250}

2. POST
---------------
URI--> http://localhost:8080/TheaterSeaterWeb/rest/ticketService/holdSeats
SeatHoldRequest:  {"minLevel":1,"maxLevel":2,"numSeats":2,"customerEmail":"aravind0106gmail.com"}
SeatHoldResponse: {"seatHoldCode":"a443faea-702b-4853-a6d2-b804459508d8","seatsHeld":[{"levelNumber":1,"seatNumber":1,"rowNumber":"1"},{"levelNumber":1,"seatNumber":2,"rowNumber":"1"}]}

-->SeatHoldCode is provided in the SeatHoldResponse, that can be used for Reserve seats call

3. POST
---------------
URI-->  http://localhost:8080/TheaterSeaterWeb/rest/ticketService/reserveSeat
ReserveSeatsInput:  {"seatHoldCode":"a443faea-702b-4853-a6d2-b804459508d8","customerEmail":"aravind0106gmail"}
ReserveSeatsOutput: {"confirmationCode":"aravind0106gmaila443faea-702b-4853-a6d2-b804459508d8"}

-->ConfirmationCODE  is string generated by sytem. This CODE is attached to every seat for the reference.


__________________________
About the Application::::
___________________________

This is a Maven multi module project that has below modules
a.TheaterSeater->Parent
b.TheaterSeaterCommonObjects->child
c.TheaterSeaterData->child
d.TheaterSeaterService->child
e.TheaterSeaterRest->child
f.TheaterSeaterWeb->child
g.TheaterSeaterInterfaces->child

. Spring 3.0.5(Annotation based) is Used for Dependency Injection

. Mockito is used for testing JUNIT 

. Concurrency is accomplished by using ConcurrentHashMap at Row level

. JERSEY is used for creating Rest based API

. jaxb-api is used to convert xml to java objects

. JSON Media type can be used to interact with REST API

. Java simple logging is used



_______________________________________
Application Functional Scenarios accomodated
________________________________________
  
1. get number of available seats for each level
2. hold any number of seats across the rows,levels. You will get a List of SeatsHeld in the response
	a. if number of seats booked by a group 

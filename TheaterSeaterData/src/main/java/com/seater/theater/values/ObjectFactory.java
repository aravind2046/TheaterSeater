//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.19 at 12:45:36 AM EST 
//


package com.seater.theater.values;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.seater.theater.values package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SeatsInRow_QNAME = new QName("", "seatsInRow");
    private final static QName _Price_QNAME = new QName("", "price");
    private final static QName _Name_QNAME = new QName("", "name");
    private final static QName _Rows_QNAME = new QName("", "rows");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.seater.theater.values
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Level }
     * 
     */
    public Level createLevel() {
        return new Level();
    }

    /**
     * Create an instance of {@link Levels }
     * 
     */
    public Levels createLevels() {
        return new Levels();
    }

    /**
     * Create an instance of {@link Theater }
     * 
     */
    public Theater createTheater() {
        return new Theater();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "seatsInRow")
    public JAXBElement<Integer> createSeatsInRow(Integer value) {
        return new JAXBElement<Integer>(_SeatsInRow_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "price")
    public JAXBElement<Float> createPrice(Float value) {
        return new JAXBElement<Float>(_Price_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rows")
    public JAXBElement<Integer> createRows(Integer value) {
        return new JAXBElement<Integer>(_Rows_QNAME, Integer.class, null, value);
    }

}
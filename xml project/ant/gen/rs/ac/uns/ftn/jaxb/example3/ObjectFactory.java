//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.18 at 10:52:54 PM CEST 
//


package rs.ac.uns.ftn.jaxb.example3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.jaxb.example3 package. 
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

    private final static QName _OdslusanPredmet_QNAME = new QName("http://www.ftn.uns.ac.rs/jaxb/example3", "odslusan_predmet");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.jaxb.example3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Predmet }
     * 
     */
    public Predmet createPredmet() {
        return new Predmet();
    }

    /**
     * Create an instance of {@link OdslusaniPredmeti }
     * 
     */
    public OdslusaniPredmeti createOdslusaniPredmeti() {
        return new OdslusaniPredmeti();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link PolozenIspit }
     * 
     */
    public PolozenIspit createPolozenIspit() {
        return new PolozenIspit();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Predmet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/jaxb/example3", name = "odslusan_predmet")
    public JAXBElement<Predmet> createOdslusanPredmet(Predmet value) {
        return new JAXBElement<Predmet>(_OdslusanPredmet_QNAME, Predmet.class, null, value);
    }

}
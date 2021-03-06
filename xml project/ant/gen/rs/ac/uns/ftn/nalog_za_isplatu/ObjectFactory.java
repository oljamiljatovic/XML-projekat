//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.18 at 10:52:55 PM CEST 
//


package rs.ac.uns.ftn.nalog_za_isplatu;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.ac.uns.ftn.nalog_za_isplatu package. 
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

    private final static QName _BrojRacuna_QNAME = new QName("http://www.ftn.uns.ac.rs/nalog_za_isplatu", "broj_racuna");
    private final static QName _PodaciOZaduzenju_QNAME = new QName("http://www.ftn.uns.ac.rs/nalog_za_isplatu", "podaci_o_zaduzenju");
    private final static QName _PodaciOPrimaocu_QNAME = new QName("http://www.ftn.uns.ac.rs/nalog_za_isplatu", "podaci_o_primaocu");
    private final static QName _PodaciOIsplatiocu_QNAME = new QName("http://www.ftn.uns.ac.rs/nalog_za_isplatu", "podaci_o_isplatiocu");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.ac.uns.ftn.nalog_za_isplatu
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Iznos }
     * 
     */
    public Iznos createIznos() {
        return new Iznos();
    }

    /**
     * Create an instance of {@link PodaciOIsplati }
     * 
     */
    public PodaciOIsplati createPodaciOIsplati() {
        return new PodaciOIsplati();
    }

    /**
     * Create an instance of {@link TPodaci }
     * 
     */
    public TPodaci createTPodaci() {
        return new TPodaci();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link NalogZaIsplatu }
     * 
     */
    public NalogZaIsplatu createNalogZaIsplatu() {
        return new NalogZaIsplatu();
    }

    /**
     * Create an instance of {@link TPravnoLiceIsplatilac }
     * 
     */
    public TPravnoLiceIsplatilac createTPravnoLiceIsplatilac() {
        return new TPravnoLiceIsplatilac();
    }

    /**
     * Create an instance of {@link TPravnoLicePrimalac }
     * 
     */
    public TPravnoLicePrimalac createTPravnoLicePrimalac() {
        return new TPravnoLicePrimalac();
    }

    /**
     * Create an instance of {@link TFizickoLicePrimalac }
     * 
     */
    public TFizickoLicePrimalac createTFizickoLicePrimalac() {
        return new TFizickoLicePrimalac();
    }

    /**
     * Create an instance of {@link TFizickoLiceIsplatilac }
     * 
     */
    public TFizickoLiceIsplatilac createTFizickoLiceIsplatilac() {
        return new TFizickoLiceIsplatilac();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/nalog_za_isplatu", name = "broj_racuna")
    public JAXBElement<String> createBrojRacuna(String value) {
        return new JAXBElement<String>(_BrojRacuna_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPodaci }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/nalog_za_isplatu", name = "podaci_o_zaduzenju")
    public JAXBElement<TPodaci> createPodaciOZaduzenju(TPodaci value) {
        return new JAXBElement<TPodaci>(_PodaciOZaduzenju_QNAME, TPodaci.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLicePrimalac }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/nalog_za_isplatu", name = "podaci_o_primaocu")
    public JAXBElement<TLicePrimalac> createPodaciOPrimaocu(TLicePrimalac value) {
        return new JAXBElement<TLicePrimalac>(_PodaciOPrimaocu_QNAME, TLicePrimalac.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLiceIsplatilac }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/nalog_za_isplatu", name = "podaci_o_isplatiocu")
    public JAXBElement<TLiceIsplatilac> createPodaciOIsplatiocu(TLiceIsplatilac value) {
        return new JAXBElement<TLiceIsplatilac>(_PodaciOIsplatiocu_QNAME, TLiceIsplatilac.class, null, value);
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.18 at 10:52:55 PM CEST 
//


package rs.ac.uns.ftn.nalog_za_isplatu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/nalog_za_isplatu}podaci_o_isplatiocu"/>
 *         &lt;element name="svrha_placanja">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/nalog_za_isplatu}podaci_o_primaocu"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/nalog_za_isplatu}podaci_o_isplati"/>
 *       &lt;/sequence>
 *       &lt;attribute name="datum_prijema" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="broj_licne_karte_primaoca" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="datum_valute" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "podaciOIsplatiocu",
    "svrhaPlacanja",
    "podaciOPrimaocu",
    "podaciOIsplati"
})
@XmlRootElement(name = "nalog_za_isplatu")
public class NalogZaIsplatu {

    @XmlElement(name = "podaci_o_isplatiocu", required = true)
    protected TLiceIsplatilac podaciOIsplatiocu;
    @XmlElement(name = "svrha_placanja", required = true)
    protected String svrhaPlacanja;
    @XmlElement(name = "podaci_o_primaocu", required = true)
    protected TLicePrimalac podaciOPrimaocu;
    @XmlElement(name = "podaci_o_isplati", required = true)
    protected PodaciOIsplati podaciOIsplati;
    @XmlAttribute(name = "datum_prijema", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumPrijema;
    @XmlAttribute(name = "broj_licne_karte_primaoca")
    protected Integer brojLicneKartePrimaoca;
    @XmlAttribute(name = "datum_valute")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumValute;

    /**
     * Gets the value of the podaciOIsplatiocu property.
     * 
     * @return
     *     possible object is
     *     {@link TLiceIsplatilac }
     *     
     */
    public TLiceIsplatilac getPodaciOIsplatiocu() {
        return podaciOIsplatiocu;
    }

    /**
     * Sets the value of the podaciOIsplatiocu property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLiceIsplatilac }
     *     
     */
    public void setPodaciOIsplatiocu(TLiceIsplatilac value) {
        this.podaciOIsplatiocu = value;
    }

    /**
     * Gets the value of the svrhaPlacanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvrhaPlacanja() {
        return svrhaPlacanja;
    }

    /**
     * Sets the value of the svrhaPlacanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvrhaPlacanja(String value) {
        this.svrhaPlacanja = value;
    }

    /**
     * Gets the value of the podaciOPrimaocu property.
     * 
     * @return
     *     possible object is
     *     {@link TLicePrimalac }
     *     
     */
    public TLicePrimalac getPodaciOPrimaocu() {
        return podaciOPrimaocu;
    }

    /**
     * Sets the value of the podaciOPrimaocu property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLicePrimalac }
     *     
     */
    public void setPodaciOPrimaocu(TLicePrimalac value) {
        this.podaciOPrimaocu = value;
    }

    /**
     * Gets the value of the podaciOIsplati property.
     * 
     * @return
     *     possible object is
     *     {@link PodaciOIsplati }
     *     
     */
    public PodaciOIsplati getPodaciOIsplati() {
        return podaciOIsplati;
    }

    /**
     * Sets the value of the podaciOIsplati property.
     * 
     * @param value
     *     allowed object is
     *     {@link PodaciOIsplati }
     *     
     */
    public void setPodaciOIsplati(PodaciOIsplati value) {
        this.podaciOIsplati = value;
    }

    /**
     * Gets the value of the datumPrijema property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumPrijema() {
        return datumPrijema;
    }

    /**
     * Sets the value of the datumPrijema property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumPrijema(XMLGregorianCalendar value) {
        this.datumPrijema = value;
    }

    /**
     * Gets the value of the brojLicneKartePrimaoca property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBrojLicneKartePrimaoca() {
        return brojLicneKartePrimaoca;
    }

    /**
     * Sets the value of the brojLicneKartePrimaoca property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBrojLicneKartePrimaoca(Integer value) {
        this.brojLicneKartePrimaoca = value;
    }

    /**
     * Gets the value of the datumValute property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumValute() {
        return datumValute;
    }

    /**
     * Sets the value of the datumValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumValute(XMLGregorianCalendar value) {
        this.datumValute = value;
    }

}
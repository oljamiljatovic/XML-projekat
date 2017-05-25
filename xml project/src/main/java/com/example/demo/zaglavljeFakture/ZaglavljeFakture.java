//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.19 at 01:26:07 PM CEST 
//

package com.example.demo.zaglavljeFakture;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.example.demo.model.Adapter1;

import lombok.Data;

@Entity
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ZaglavljeFakture {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ZAGLAVLJE_FAKTURE_ID")
	private Long id;
	
	@XmlElement(required = true)
    protected String nazivDobavljaca;
	
    @XmlElement(required = true)
    protected String adresaDobavljaca;
    
    @XmlElement(name = "PIBDobavljaca", required = true)
    protected String pibDobavljaca;
    
    @XmlElement(required = true)
    protected String nazivKupca;
    
    @XmlElement(required = true)
    protected String adresaKupca;
    
    @XmlElement(name = "PIBKupca", required = true)
    protected String pibKupca;
    
    @XmlElement(required = true)
    protected BigInteger brojRacuna;
    
    @XmlJavaTypeAdapter(Adapter1.class)
    @XmlElement(required = true)
    protected Date datumRacuna;
    
   
    @XmlElement(required = true)
    protected BigDecimal vrednostRobe;
    
    @XmlElement(required = true)
    protected BigDecimal vrednostUsluga;
    
    @XmlElement(required = true)
    protected BigDecimal ukupnoRobaIUsluge;
    
    @XmlElement(required = true)
    protected BigDecimal ukupanRabat;
    
    @XmlElement(required = true)
    protected BigDecimal ukupanPorez;
    
    @XmlElement(required = true)
    protected String oznakaValute;
    
    @XmlElement(required = true)
    protected BigDecimal iznosZaUplatu;
    
    @XmlElement(required = true)
    protected String uplataNaRacun;
    
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(Adapter1.class)
    protected Date datumValute;

  
}

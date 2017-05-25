//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.19 at 01:26:07 PM CEST 
//
package com.example.demo.stavkaFakture;


import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;

@Entity
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class StavkaFakture {

	
	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STAVKA_FAKTURE_ID")
	private Long id;
	
	@XmlElement(required = true)
    protected BigInteger redniBroj;
	
    @XmlElement(required = true)
    protected String nazivRobeIliUsluge;
    
    @XmlElement(required = true)
    protected BigDecimal kolicina;
    
    @XmlElement(required = true)
    protected String jedinicaMere;
    
    @XmlElement(required = true)
    protected BigDecimal jedinicnaCena;
    
    @XmlElement(required = true)
    protected BigDecimal vrednost;
    
    @XmlElement(required = true)
    protected BigDecimal procenatRabata;
    
    @XmlElement(required = true)
    protected BigDecimal iznosRabata;
    
    @XmlElement(required = true)
    protected BigDecimal umanjenoZaRabat;
    
    @XmlElement(required = true)
    protected BigDecimal ukupanPorez;
   
  
 
}
package com.example.demo.zaglavljePreseka;

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
public class ZaglavljePreseka {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ZAGLAVLJE_PRESEKA_ID")
	private Long id;
	
	@XmlElement(required = true)
	private String brojRacuna; 
	
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlElement(required = true)
	private Date datumNaloga;
	
	@XmlElement(required = true)
	private BigInteger brojPreseka;
	
	@XmlElement(required = true)
	private BigDecimal prethodnoStanje;

	@XmlElement(required = true)
	private BigInteger brojPromenaUKorist;

	@XmlElement(required = true)
	private BigDecimal ukupnoUKorist;
	
	@XmlElement(required = true)
	private BigInteger brojPromenaNaTeret;
	
	@XmlElement(required = true)
	private BigDecimal ukupnoNaTeret; 
	
	@XmlElement(required = true)
	private BigDecimal novoStanje;
}

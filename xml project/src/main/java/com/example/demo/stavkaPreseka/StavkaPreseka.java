package com.example.demo.stavkaPreseka;

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
public class StavkaPreseka {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STAVKA_PRESEKA_ID")
	private Long id;
	
	@XmlElement(required = true)
	private String duznik;
	
	@XmlElement(required = true)
	private String svrhaPlacanja;
	
	@XmlElement(required = true)
	private String primalac;
	
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlElement(required = true)
	private Date datumNaloga;

	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlElement(required = true)
	private Date datumValute;
	
	@XmlElement(required = true)
	private String racunDuznika;
	
	@XmlElement(required = true)
	private BigInteger modelZaduzenja;
	
	@XmlElement(required = true)
	private String pozivNaBrojZaduzenja;

	@XmlElement(required = true)
	private String racunPrimaoca;
	
	@XmlElement(required = true)
	private BigInteger modelOdobrenja;
	
	@XmlElement(required = true)
	private String pozivNaBrojOdobrenja;
	
	@XmlElement(required = true)
	private BigDecimal iznos;

	@XmlElement(required = true)
	private String smer;
}

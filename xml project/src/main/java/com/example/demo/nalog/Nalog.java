package com.example.demo.nalog;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.example.demo.model.Adapter1;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "nalog")
@Data
@Entity
public class Nalog {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "NALOG_ID")
	private Long id;
	
	@XmlElement(required = true)
	protected String idPoruke;
	
	@XmlElement(required = true)
	protected String duznik;

	@XmlElement(required = true)
	protected String svrhaPlacanja;

	@XmlElement(required = true)
	protected String primalac;

	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlElement(required = true)
	protected Date datumNaloga;
	
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlElement(required = true)
	protected Date datumValute;
	
	@XmlElement(required = true)
	protected String racunDuznika;
	
	@XmlElement(required = true)
	protected BigInteger modelZaduzenja;
	
	@XmlElement(required = true)
	protected String pozivNaBrojZaduzenja;
	
	@XmlElement(required = true)
	protected String racunPrimaoca;
	
	@XmlElement(required = true)
	protected BigInteger modelOdobrenja;
	
	@XmlElement(required = true)
	protected String pozivNaBrojOdobrenja;
	
	@XmlElement(required = true)
	protected BigDecimal iznos;
	
	@XmlElement(required = true)
	protected String oznakaValute;
	
	@XmlElement(required = true)
	protected Boolean hitno;
}

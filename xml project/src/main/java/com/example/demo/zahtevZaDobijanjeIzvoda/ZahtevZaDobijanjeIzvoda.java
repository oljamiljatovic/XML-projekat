package com.example.demo.zahtevZaDobijanjeIzvoda;

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

@Entity
@Data
@XmlRootElement(name = "zahtevZaDobijanjeIzvoda")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZahtevZaDobijanjeIzvoda {


	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ZAHTEV_ZA_DOBIJANJE_IZVODA_ID")
	private Long id;
	
	@XmlElement(required = true)
	private String brojRacuna;
	
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlElement(required = true)
	private Date datum;
	
	@XmlElement(required = true)
	private BigInteger redniBrojPreseka;
	
}

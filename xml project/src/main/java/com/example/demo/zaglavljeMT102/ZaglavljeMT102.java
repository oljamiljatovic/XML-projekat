package com.example.demo.zaglavljeMT102;

import java.math.BigDecimal;

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
public class ZaglavljeMT102 {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ZAGLAVLJE_MT102_ID")
	private Long id;
	
	@XmlElement(required = true)
	private String idPoruke; //50
    
	@XmlElement(required = true)
	private String swiftKodBankeDuznika; //8 
	
	@XmlElement(required = true)
	private String obracunskiRacunBankeDuznika; //18
	
	@XmlElement(required = true)	
	private String swiftKodBankePoverioca; //8
	
	@XmlElement(required = true)
	private String obracunskiRacunBankePoverioca; //18
	
	@XmlElement(required = true)
	private BigDecimal ukupanIznos; //15-2
	
	@XmlElement(required = true)
	private String sifraValute;//3
	
	@XmlJavaTypeAdapter(Adapter1.class)
    @XmlElement(required = true)
	private Date datumValute;
	
	@XmlJavaTypeAdapter(Adapter1.class)
    @XmlElement(required = true)
	private Date datum; 
}

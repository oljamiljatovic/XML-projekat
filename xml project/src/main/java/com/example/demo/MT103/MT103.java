package com.example.demo.MT103;

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
@XmlRootElement(name = "mt103")
@Data
@Entity
public class MT103 {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MT103_ID")
	private Long id;
	
	@XmlElement(required = true)
	private String idPoruke;
	
	@XmlElement(required = true)
	private String swiftKodBankeDuznika; //8
	
	@XmlElement(required = true)
	private String obracunskiRacunBankeDuznika; //18
   
	@XmlElement(required = true)
	private String swiftKodBankePoverioca; //8
	
	@XmlElement(required = true)
	private String obracunskiRacunBankePoverioca; //18
	
	@XmlElement(required = true)
	private String duznik; //255
	
	@XmlElement(required = true)
	private String svrhaPlacanja; //255
	
	@XmlElement(required = true)
	private String primalac; //255
	
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlElement(required = true)
	private Date datumNaloga;
	
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlElement(required = true)
	private Date datumValute; 
	
	@XmlElement(required = true)
	private String racunDuznika; //18
	
	@XmlElement(required = true)
	private BigInteger modelZaduzenja; //2
	
	@XmlElement(required = true)
	private String pozivNaBrojZaduzenja; //20
    
	@XmlElement(required = true)
	private String racunPoverioca; //18
	
	@XmlElement(required = true)
	private BigInteger modelOdobrenja; //2
	
	@XmlElement(required = true)
	private String pozivNaBrojOdobrenja; //20
	
	@XmlElement(required = true)
	private BigDecimal iznos; //15.2
	
	@XmlElement(required = true)
	private String sifraValute; //3
	
   
}

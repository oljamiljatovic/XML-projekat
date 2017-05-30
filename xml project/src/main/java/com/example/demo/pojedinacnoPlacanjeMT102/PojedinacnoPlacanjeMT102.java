package com.example.demo.pojedinacnoPlacanjeMT102;

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
public class PojedinacnoPlacanjeMT102 {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "P_PLACANJE_MT102_ID")
	private Long id;
	
	@XmlElement(required = true)
	private String idNalogaZaPlacanje;//50
	
	@XmlElement(required = true)
	private String duznik; //255
   
	@XmlElement(required = true)
	private String svrhaPlacanja;//255
    
	@XmlElement(required = true)
	private String primalac;//255
   
	@XmlJavaTypeAdapter(Adapter1.class)
    @XmlElement(required = true)
	private Date datumNaloga;
    
	@XmlElement(required = true)
	private String racunDuznika;//18
    
	@XmlElement(required = true)
	private BigInteger modelZaduzenja;//2
    
	@XmlElement(required = true)
	private String pozivNaBrojZaduzenja;//20
    
	@XmlElement(required = true)
	private String racunPoverioca;//18
    
	@XmlElement(required = true)
	private BigInteger modelOdobrenja;//2
    
	@XmlElement(required = true)
	private String pozivNaBrojOdobrenja;//20
    
	@XmlElement(required = true)
	private BigDecimal iznos;//15-2

	@XmlElement(required = true)
	private String sifraValute;//3
   

      
}

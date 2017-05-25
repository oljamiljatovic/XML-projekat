package com.example.demo.MT900;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.example.demo.model.Adapter1;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mt900")
@Data
@Entity
public class MT900 {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MT900_ID")
	private Long id;
	
	@XmlElement(required = true)
	private String idPoruke;
	
	@XmlElement(required = true)
	private String swiftKodBankeDuznika; //8
    
	@XmlElement(required = true)
	private String obracunskiRacunBankeDuznika; //20
    
	@XmlElement(required = true)
	private String idPorukeNaloga;//50
	
	@XmlJavaTypeAdapter(Adapter1.class)
	@XmlElement(required = true)
	private Date datumValute;
    
	@XmlElement(required = true)
	private BigDecimal iznos;//15.2
   
	@XmlElement(required = true)
	private String sifraValute;//3
     
}

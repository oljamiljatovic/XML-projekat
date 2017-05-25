package com.example.demo.presek;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.example.demo.stavkaPreseka.StavkaPreseka;
import com.example.demo.zaglavljePreseka.ZaglavljePreseka;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "presek")
@Data
@Entity
public class Presek {


	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRESEK_ID")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "ZAGLAVLJE_PRESEKA_ID")
    @XmlElement(required = true)
    protected ZaglavljePreseka zaglavljePreseka;
    
    
	@OneToMany
	@JoinTable(name = "PRESEK_STAVKA_PRESEKA", joinColumns = @JoinColumn(name = "PRESEK_ID"), inverseJoinColumns = @JoinColumn(name = "STAVKA_PRESEKA_ID"))
    @XmlElement(required = true)
    protected List<StavkaPreseka> stavkaPreseka = new ArrayList<StavkaPreseka>();

}

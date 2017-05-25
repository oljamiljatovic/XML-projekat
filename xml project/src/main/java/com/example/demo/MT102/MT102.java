package com.example.demo.MT102;

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


import com.example.demo.pojedinacnoPlacanjeMT102.PojedinacnoPlacanjeMT102;

import com.example.demo.zaglavljeMT102.ZaglavljeMT102;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mt102")
@Data
@Entity
public class MT102 {

	@XmlTransient
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MT102_ID")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "ZAGLAVLJE_MT102_ID")
    @XmlElement(required = true)
    protected ZaglavljeMT102 zaglavljeMT102;
    
    
	@OneToMany
	@JoinTable(name = "MT102_P_PLACANJE_MT102", joinColumns = @JoinColumn(name = "MT102_ID"), inverseJoinColumns = @JoinColumn(name = "P_PLACANJE_MT102_ID"))
    @XmlElement(required = true)
    protected List<PojedinacnoPlacanjeMT102> pojedinacnoPlacanjeMT102 = new ArrayList<PojedinacnoPlacanjeMT102>();

}

package com.example.demo.firma;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.validator.constraints.NotBlank;

import com.example.demo.stavkaFakture.StavkaFakture;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Firma {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FIRMA_ID")
	private Long id;
	
	@NotBlank
	@Column
	private String naziv;
	
	@NotBlank
	@Column
	private String adresa;
	
	@NotBlank
	@Column
	private String PIB;
	
	@JsonIgnore
	@OneToMany
	@JoinTable(name = "POSLOVNI_SARADNICI", joinColumns = @JoinColumn(name = "FIRMA1_ID"), inverseJoinColumns = @JoinColumn(name = "FIRMA2_ID"))
    protected List<Firma> poslovniSaradnici = new ArrayList<Firma>();

}

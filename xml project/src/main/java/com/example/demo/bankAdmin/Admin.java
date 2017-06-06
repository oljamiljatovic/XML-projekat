package com.example.demo.bankAdmin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.banka.Banka;
import com.example.demo.firma.Firma;
import com.example.demo.user.User;

import lombok.Data;

@Data
@Entity
public class Admin  extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADMIN_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "BANKA_ID")
	private Banka banka;
	
	@ManyToOne
	@JoinColumn(name = "FIRMA_ID")
	private Firma firma;
}

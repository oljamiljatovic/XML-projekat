
package com.example.demo.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DepositSlip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPOSIT_SLIP_ID")
	private Long id;
	
	
	public enum Type {
	    TRANSFER, //prenos
	    PAYMENTOUT, //uplata
	    PAYOUT, //isplata
	    PAYMENTIN //naplata
	} 
	
	@Column
    @Enumerated(EnumType.STRING)
	private Type type;
	private String deptor; //duznik
	
	private String receiver; //primalac
	
	private String purposeOfPayment; //svrha placanja
	
	private Date currencyDate; //datum valute
	
	private Date depositSlipDate; //datum naloga
	
	private String billOfDeptor; //racun duznika 18
	
	private int modelAssignment; //model zaduzenja 2
	
	private String referenceNumberAssignment; // poziv na broj zaduzenja 20
	
	private String billOfReceiver; //racun primaoca 18
	
	private int modelApproval; //model odobrenja 2
	
	private String referenceNumberApproval; //poziv na broj odobrenja 20
	
	private double amount; //iznos
	
	private String codeOfCurrency; //sifra valute 3
	
	private boolean urgently; //hitno
	
	private boolean direction; //smjer provjeriti tip - na stetu, na korist
	
	
	

		
}

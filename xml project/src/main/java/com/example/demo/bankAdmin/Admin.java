package com.example.demo.bankAdmin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.user.User;

import lombok.Data;

@Data
@Entity
public class Admin  extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BANKER_ID")
	private Long id;
}

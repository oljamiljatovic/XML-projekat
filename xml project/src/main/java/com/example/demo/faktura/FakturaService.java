package com.example.demo.faktura;

import java.util.List;


public interface FakturaService {
	
	public List<Faktura> findAll();

	public Faktura save(Faktura faktura);

	public Faktura findOne(Long id);
	
	Faktura findByZaglavljeFakture_Id(Long id); 
	
	public void delete(Long id);
	
	List<Faktura> findByZaglavljeFakture_PibKupca(String pibKupca); 



}

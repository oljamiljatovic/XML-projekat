package com.example.demo.faktura;

import java.util.List;


public interface FakturaService {
	
	public List<Faktura> findAll();

	public Faktura save(Faktura faktura);

	public Faktura findOne(Long id);
}

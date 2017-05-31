package com.example.demo.faktura;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FakturaRepository extends PagingAndSortingRepository<Faktura, Long> {
	
	Faktura findByZaglavljeFakture_Id(Long id); 
 
}

package com.example.demo.firma;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FirmaRepository extends PagingAndSortingRepository<Firma, Long>{
	
	List<Firma> findByPoslovniSaradnici(List<Firma> firma);
	
	Firma findByPoslovniSaradnici_PIB(String pib);


}

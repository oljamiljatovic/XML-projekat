package com.example.demo.firma;

import java.util.List;

public interface FirmaService {
	public Firma findOne(Long id);
	
	List<Firma> findByPoslovniSaradnici(List<Firma> firma);

}

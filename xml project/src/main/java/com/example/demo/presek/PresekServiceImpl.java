package com.example.demo.presek;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.stavkaPreseka.StavkaPreseka;
import com.example.demo.stavkaPreseka.StavkaPresekaRepository;
import com.example.demo.zaglavljePreseka.ZaglavljePreseka;
import com.example.demo.zaglavljePreseka.ZaglavljePresekaRepository;

@Service
@Transactional
public class PresekServiceImpl implements PresekService {


	private final PresekRepository presekRepository;
	private final ZaglavljePresekaRepository zaglavljePresekaRepository;
	private final StavkaPresekaRepository stavkaPresekaRepository;
	
	@Autowired
	public PresekServiceImpl(final PresekRepository presekRepository, final ZaglavljePresekaRepository zaglavljePresekaRepository , final StavkaPresekaRepository stavkaPresekaRepository) {
		this.presekRepository = presekRepository;
		this.zaglavljePresekaRepository = zaglavljePresekaRepository;
		this.stavkaPresekaRepository = stavkaPresekaRepository;
	}
	
	@Override
	public List<Presek> findAll() {
		return (List<Presek>) presekRepository.findAll();
	}

	@Override
	public Presek save(Presek presek) {
		ZaglavljePreseka zaglavlje = zaglavljePresekaRepository.save(presek.getZaglavljePreseka());
		presek.setZaglavljePreseka(zaglavlje);
		
		
		for(int i = 0 ;i <presek.getStavkaPreseka().size(); i++){
			StavkaPreseka stavka = stavkaPresekaRepository.save(presek.getStavkaPreseka().get(i));
			presek.getStavkaPreseka().set(i,stavka);			
		}
		
		return presekRepository.save(presek);
	}

	@Override
	public Presek findOne(Long id) {
		return presekRepository.findOne(id);
	}

}

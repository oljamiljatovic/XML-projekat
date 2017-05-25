package com.example.demo.zaglavljePreseka;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Transactional
public class ZaglavljePresekaServiceImpl implements ZaglavljePresekaService {

	private final ZaglavljePresekaRepository zaglavljePresekaRepository;
	
	@Autowired
	public ZaglavljePresekaServiceImpl(final ZaglavljePresekaRepository zaglavljePresekaRepository) {
		this.zaglavljePresekaRepository = zaglavljePresekaRepository;
	}
	@Override
	public List<ZaglavljePreseka> findAll() {
		return (List<ZaglavljePreseka>) zaglavljePresekaRepository.findAll();
	}

	@Override
	public ZaglavljePreseka save(ZaglavljePreseka zaglavljePreseka) {
		return zaglavljePresekaRepository.save(zaglavljePreseka);
	}

	@Override
	public ZaglavljePreseka findOne(Long id) {
		return zaglavljePresekaRepository.findOne(id);
	}

}

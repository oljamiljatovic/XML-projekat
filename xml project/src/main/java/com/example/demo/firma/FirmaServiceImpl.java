package com.example.demo.firma;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FirmaServiceImpl implements FirmaService{
	
	private final FirmaRepository firmaRepository;
	
	@Autowired
	public FirmaServiceImpl(final FirmaRepository firmaRepository) {
		this.firmaRepository = firmaRepository;
	}

	@Override
	public Firma findOne(Long id) {
		return firmaRepository.findOne(id);
	}

	@Override
	public List<Firma> findByPoslovniSaradnici(List<Firma> firma) {
		// TODO Auto-generated method stub
		return firmaRepository.findByPoslovniSaradnici(firma);
	}
}

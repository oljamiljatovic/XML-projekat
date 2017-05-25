package com.example.demo.stavkaPreseka;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class StavkaPresekaServiceImpl implements StavkaPresekaService {

	private final StavkaPresekaRepository stavkaPresekaRepository;
	
	@Autowired
	public StavkaPresekaServiceImpl(final StavkaPresekaRepository stavkaPresekaRepository) {
		this.stavkaPresekaRepository = stavkaPresekaRepository;
	}
	
	@Override
	public List<StavkaPreseka> findAll() {
		return (List<StavkaPreseka>) stavkaPresekaRepository.findAll();
	}

	@Override
	public StavkaPreseka save(StavkaPreseka stavkaPreseka) {
		return stavkaPresekaRepository.save(stavkaPreseka);	
	}

	@Override
	public StavkaPreseka findOne(Long id) {
		return stavkaPresekaRepository.findOne(id);
	}

}

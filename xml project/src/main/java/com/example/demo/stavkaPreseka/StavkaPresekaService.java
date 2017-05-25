package com.example.demo.stavkaPreseka;

import java.util.List;


public interface StavkaPresekaService {


	public List<StavkaPreseka> findAll();

	public StavkaPreseka save(StavkaPreseka stavkaPreseka);

	public StavkaPreseka findOne(Long id);
}

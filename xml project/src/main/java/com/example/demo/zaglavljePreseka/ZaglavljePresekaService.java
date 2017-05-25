package com.example.demo.zaglavljePreseka;

import java.util.List;


public interface ZaglavljePresekaService {

	public List<ZaglavljePreseka> findAll();

	public ZaglavljePreseka save(ZaglavljePreseka zaglavljePreseka);

	public ZaglavljePreseka findOne(Long id);
}

package com.example.demo.presek;

import java.util.List;

public interface PresekService {

	public List<Presek> findAll();

	public Presek save(Presek presek);

	public Presek findOne(Long id);
}

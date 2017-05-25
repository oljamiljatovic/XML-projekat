package com.example.demo.nalog;

import java.util.List;


public interface NalogService {

	public List<Nalog> findAll();

	public Nalog save(Nalog nalog);

	public Nalog findOne(Long id);
}

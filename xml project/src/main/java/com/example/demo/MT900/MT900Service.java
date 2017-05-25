package com.example.demo.MT900;

import java.util.List;

public interface MT900Service {
	
	public List<MT900> findAll();

	public MT900 save(MT900 mt900);

	public MT900 findOne(Long id);
}

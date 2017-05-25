package com.example.demo.MT910;

import java.util.List;

public interface MT910Service {

	public List<MT910> findAll();

	public MT910 save(MT910 mt910);

	public MT910 findOne(Long id);
}

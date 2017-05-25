package com.example.demo.MT900;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class MT900ServiceImpl implements MT900Service {

	private final MT900Repository MT900Repository;
	
	@Autowired
	public MT900ServiceImpl(final MT900Repository MT900Repository) {
		this.MT900Repository = MT900Repository;
	}
	
	@Override
	public List<MT900> findAll() {
		return (List<MT900>) MT900Repository.findAll();
	}

	@Override
	public MT900 save(MT900 mt900) {
		return MT900Repository.save(mt900);
	}

	@Override
	public MT900 findOne(Long id) {
		return MT900Repository.findOne(id);
	}

}

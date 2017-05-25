package com.example.demo.model;

import java.util.List;


public interface DepositSlipService {

	public List<DepositSlip> findAll();

	public DepositSlip save(DepositSlip depositSlip);

	public DepositSlip findOne(Long id);
}

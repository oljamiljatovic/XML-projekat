package com.example.demo.banka;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bankAdmin.AdminRepository;
import com.example.demo.bankAdmin.AdminService;

@Service
@Transactional
public class BankaServiceImpl implements BankaService{
private final BankaRepository bankaRepository;
	
	@Autowired
	public BankaServiceImpl(final BankaRepository bankaRepository) {
		this.bankaRepository = bankaRepository;
	}

	@Override
	public Banka findOne(Long id) {
		return bankaRepository.findOne(id);
	}
	
}

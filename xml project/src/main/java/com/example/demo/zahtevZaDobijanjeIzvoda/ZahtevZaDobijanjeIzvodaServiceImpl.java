package com.example.demo.zahtevZaDobijanjeIzvoda;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ZahtevZaDobijanjeIzvodaServiceImpl implements ZahtevZaDobijanjeIzvodaService {


	private final ZahtevZaDobijanjeIzvodaRepository zahtevZaDobijanjeIzvodaRepository;
	
	@Autowired
	public ZahtevZaDobijanjeIzvodaServiceImpl(final ZahtevZaDobijanjeIzvodaRepository zahtevZaDobijanjeIzvodaRepository) {
		this.zahtevZaDobijanjeIzvodaRepository = zahtevZaDobijanjeIzvodaRepository;
	}
	
	@Override
	public List<ZahtevZaDobijanjeIzvoda> findAll() {
		return (List<ZahtevZaDobijanjeIzvoda>) zahtevZaDobijanjeIzvodaRepository.findAll();
	}

	@Override
	public ZahtevZaDobijanjeIzvoda save(ZahtevZaDobijanjeIzvoda zahtev) {
		return zahtevZaDobijanjeIzvodaRepository.save(zahtev);
	}

	@Override
	public ZahtevZaDobijanjeIzvoda findOne(Long id) {
		return zahtevZaDobijanjeIzvodaRepository.findOne(id);
	}

}

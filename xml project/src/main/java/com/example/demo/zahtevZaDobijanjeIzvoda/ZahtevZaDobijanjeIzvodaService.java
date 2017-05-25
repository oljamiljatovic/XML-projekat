package com.example.demo.zahtevZaDobijanjeIzvoda;

import java.util.List;


public interface ZahtevZaDobijanjeIzvodaService {

	public List<ZahtevZaDobijanjeIzvoda> findAll();

	public ZahtevZaDobijanjeIzvoda save(ZahtevZaDobijanjeIzvoda zahtev);

	public ZahtevZaDobijanjeIzvoda findOne(Long id);
}

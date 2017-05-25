package com.example.demo.zaglavljeMT102;

import java.util.List;

public interface ZaglavljeMT102Service {

	public List<ZaglavljeMT102> findAll();

	public ZaglavljeMT102 save(ZaglavljeMT102 zaglavlje);

	public ZaglavljeMT102 findOne(Long id);
}

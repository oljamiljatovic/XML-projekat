package com.example.demo.pojedinacnoPlacanjeMT102;

import java.util.List;

public interface PojedinacnoPlacanjeMT102Service {


	public List<PojedinacnoPlacanjeMT102> findAll();

	public PojedinacnoPlacanjeMT102 save(PojedinacnoPlacanjeMT102 placanje);

	public PojedinacnoPlacanjeMT102 findOne(Long id);
}

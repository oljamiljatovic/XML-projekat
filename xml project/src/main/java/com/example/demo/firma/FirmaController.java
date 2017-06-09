package com.example.demo.firma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/firma")
public class FirmaController {
	private final FirmaService firmaService;
	
	@Autowired
	public FirmaController(final FirmaService firmaService) {
		this.firmaService = firmaService;
	}
	
	@PostMapping("/findAllPoslovniSaradnici")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Firma> findAllPoslovniSaradnici(@RequestBody Firma firma){
		ArrayList<Firma> temp = new ArrayList<Firma>();
		temp.add(firma);
		List<Firma> ps = firmaService.findByPoslovniSaradnici(temp);
		return ps;
	}
}

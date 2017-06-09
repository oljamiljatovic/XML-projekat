package com.example.demo.faktura;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/RESTApi")
public class FakturaRESTApi {

	@RequestMapping(value = "/FIRMA_A", method = RequestMethod.POST)
	public ResponseEntity<Faktura> acceptFaktura1(@RequestBody Faktura faktura) 
	{
		System.out.println("FIRMA_A");
	    System.out.println(faktura);
	    return new ResponseEntity<Faktura>(faktura, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/FIRMA_B", method = RequestMethod.POST)
	public ResponseEntity<Faktura> acceptFaktura2(@RequestBody Faktura faktura) 
	{
		System.out.println("FIRMA_B");
	    System.out.println(faktura);
	    return new ResponseEntity<Faktura>(faktura, HttpStatus.OK);
	}
	
}

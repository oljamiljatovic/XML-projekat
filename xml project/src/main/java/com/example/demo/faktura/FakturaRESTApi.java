package com.example.demo.faktura;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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

	@RequestMapping(value = "/faktura", method = RequestMethod.POST)
	public ResponseEntity<Faktura> sendFaktura(@RequestBody Faktura faktura) 
	{
		System.out.println("RESTApi");
	    System.out.println(faktura);
	    try {

			File file = new File("DESAFaktura.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Faktura.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(faktura, file);
			jaxbMarshaller.marshal(faktura, System.out);

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }
	    return new ResponseEntity<Faktura>(faktura, HttpStatus.OK);
	}
	
}

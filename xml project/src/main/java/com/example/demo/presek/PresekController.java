package com.example.demo.presek;

import java.io.File;


import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.example.demo.model.MyValidationEventHandler;




@RestController
@RequestMapping("/presek")
public class PresekController {

	private final PresekService presekService;
	
	@Autowired
	public PresekController(final PresekService presekService){
		this.presekService = presekService;
	}
	
	
	@GetMapping("/getPresekXml")
	@ResponseStatus(HttpStatus.OK)
	public void getPresekXml() {
		try {
			File file = new File("C:\\presek.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Presek.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); //unmarshaller
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = null;
			try {
				schema = schemaFactory.newSchema(new File("C:\\presek.xsd"));
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jaxbUnmarshaller.setSchema(schema);
			jaxbUnmarshaller.setEventHandler(new MyValidationEventHandler());
			
			Presek presek = (Presek) jaxbUnmarshaller.unmarshal(file);
			presekService.save(presek);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
	
	@GetMapping("/makePresekXml")
	@ResponseStatus(HttpStatus.OK)
	public void makeXml() {
		
	/* 
	  Presek presek = presekService.findOne((long) 1);
	  
	   
	try {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsed = null;
		parsed = format.parse("2011-02-10");
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		   presek.getZaglavljePreseka().setDatumNaloga(sqlDate);
		   presek.getStavkaPreseka().get(1).setDatumNaloga(sqlDate);
		   presek.getStavkaPreseka().get(1).setDatumValute(sqlDate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
       
	  
	  

	  try {

		File file = new File("generisaniPresek.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Presek.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(presek, file);
		jaxbMarshaller.marshal(presek, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }*/
	}
	
}

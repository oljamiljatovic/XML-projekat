package com.example.demo.zahtevZaDobijanjeIzvoda;

import java.io.File;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
@RequestMapping("/zahtevZaDobijanjeIzvoda")
public class ZahtevZaDobijanjeIzvodaController {

	private final ZahtevZaDobijanjeIzvodaService zahtevZaDobijanjeIzvodaService;
	
	@Autowired
	public ZahtevZaDobijanjeIzvodaController(final ZahtevZaDobijanjeIzvodaService zahtevZaDobijanjeIzvodaService){
		this.zahtevZaDobijanjeIzvodaService = zahtevZaDobijanjeIzvodaService;
	}
	
	

	@GetMapping("/getZahtevZaDobijanjeIzvodaXml")
	@ResponseStatus(HttpStatus.OK)
	public void getZahtevZaDobijanjeIzvodaXml() {
		try {
			File file = new File("C:\\zahtevZaDobijanjeIzvoda.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(ZahtevZaDobijanjeIzvoda.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); //unmarshaller
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = null;
			try {
				schema = schemaFactory.newSchema(new File("C:\\zahtevZaDobijanjeIzvoda.xsd"));
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jaxbUnmarshaller.setSchema(schema);
			jaxbUnmarshaller.setEventHandler(new MyValidationEventHandler());
			
			ZahtevZaDobijanjeIzvoda faktura = (ZahtevZaDobijanjeIzvoda) jaxbUnmarshaller.unmarshal(file);
			zahtevZaDobijanjeIzvodaService.save(faktura);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
	
	@GetMapping("/makeZahtevZaDobijanjeIzvodaXml")
	@ResponseStatus(HttpStatus.OK)
	public void makeXml() {
		
		ZahtevZaDobijanjeIzvoda  zahtev = new ZahtevZaDobijanjeIzvoda();
	 
		zahtev.setRedniBrojPreseka(BigInteger.valueOf(13));
	  
	   
	try {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsed = null;
		parsed = format.parse("2011-02-10");
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
	    zahtev.setDatum(sqlDate);
		
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
       
	  
	   zahtev.setBrojRacuna("181818181818181818");
	   
	  try {

		File file = new File("generisanZahtevZaDobijanjeIzvoda.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(ZahtevZaDobijanjeIzvoda.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(zahtev, file);
		jaxbMarshaller.marshal(zahtev, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
	}
}

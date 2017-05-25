package com.example.demo.MT103;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
@RequestMapping("/MT103")
public class MT103Controller {

	private final MT103Service MT103Service;
	
	@Autowired
	public MT103Controller(final MT103Service MT103Service){
		this.MT103Service = MT103Service;
	}
	
	@GetMapping("/getMT103Xml")
	@ResponseStatus(HttpStatus.OK)
	public void getXml() {
		try {
			File file = new File("C:\\mt103.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(MT103.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); //unmarshaller
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = null;
			try {
				schema = schemaFactory.newSchema(new File("C:\\mt103.xsd"));
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jaxbUnmarshaller.setSchema(schema);
			jaxbUnmarshaller.setEventHandler(new MyValidationEventHandler());
			
			MT103 mt103 = (MT103) jaxbUnmarshaller.unmarshal(file);
			MT103Service.save(mt103);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
	
	
	
	@GetMapping("/makeMT103Xml")
	@ResponseStatus(HttpStatus.OK)
	public void makeXml() {
		
		MT103 mt103  = new MT103();
		mt103.setIdPoruke("poruka broj 1");
		mt103.setSwiftKodBankeDuznika("88888888"); //8
		mt103.setObracunskiRacunBankeDuznika("181818181818181818"); //18
		mt103.setSwiftKodBankePoverioca("80808080");//8
		mt103.setObracunskiRacunBankePoverioca("818181818181818181");//18
		mt103.setDuznik("duznik broj 1");//255
		mt103.setSvrhaPlacanja("svrha placanja broj 1");
		mt103.setPrimalac("primalac broj 1");
		mt103.setRacunDuznika("181818181818181818"); //18
		mt103.setModelZaduzenja(BigInteger.valueOf(97));//2
		mt103.setPozivNaBrojZaduzenja("20202020202020202020");//20
		mt103.setRacunPoverioca("181818181818181818");//18
		mt103.setModelOdobrenja(BigInteger.valueOf(97));//2
		mt103.setPozivNaBrojOdobrenja("22202020202120202020"); //20
		mt103.setIznos(new BigDecimal(122.12).setScale(2, RoundingMode.CEILING));
		mt103.setSifraValute("rsd");//3
	 
	try {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsed = null;
		parsed = format.parse("2011-02-10");
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		   mt103.setDatumNaloga(sqlDate);
		   mt103.setDatumValute(sqlDate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
  
	  try {

		File file = new File("generisanMT103.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT103.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(mt103, file);
		jaxbMarshaller.marshal(mt103, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
	}
	
}

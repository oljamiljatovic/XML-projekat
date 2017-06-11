package com.example.demo.nalog;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.example.demo.faktura.Faktura;
import com.example.demo.firma.Firma;
import com.example.demo.firma.FirmaService;
import com.example.demo.model.MyValidationEventHandler;

@RestController
@RequestMapping("/nalog")
public class NalogController {

	private final NalogService nalogService;
	private final FirmaService firmaService;

	
	@Autowired
	public NalogController(final NalogService nalogService,final FirmaService firmaService){
		this.nalogService = nalogService;
		this.firmaService = firmaService;
	}
	

	
	@GetMapping("/getNalogXml")
	@ResponseStatus(HttpStatus.OK)
	public void getXml() {
		try {
			File file = new File("C:\\nalog.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Nalog.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); //unmarshaller
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = null;
			try {
				schema = schemaFactory.newSchema(new File("C:\\nalog.xsd"));
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jaxbUnmarshaller.setSchema(schema);
			jaxbUnmarshaller.setEventHandler(new MyValidationEventHandler());
			
			Nalog nalog = (Nalog) jaxbUnmarshaller.unmarshal(file);
			nalogService.save(nalog);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
	
	
	
	@GetMapping("/makeNalogXml")
	@ResponseStatus(HttpStatus.OK)
	public void makeXml() {
		
		Nalog nalog = new Nalog();
		nalog.setIdPoruke("idPoruke1111");
		nalog.setDuznik("Duznik 1");
		nalog.setSvrhaPlacanja("Svrha placanja 1");
		nalog.setPrimalac("Primalac 1 ");
		
		nalog.setRacunDuznika("181818181818181818");
		nalog.setModelZaduzenja(BigInteger.valueOf(97));
		nalog.setPozivNaBrojZaduzenja("20202020202020202020");
		nalog.setRacunPrimaoca("771812281818181228");
		nalog.setModelOdobrenja(BigInteger.valueOf(97));
		nalog.setPozivNaBrojOdobrenja("20772022302020202020");
		nalog.setIznos(new BigDecimal(122.12).setScale(2, RoundingMode.CEILING));
		nalog.setOznakaValute("rsd");
		nalog.setHitno(true);
		
	  
	  
	   
	try {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	       Date parsed = null;
		parsed = format.parse("2011-02-10");
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		   nalog.setDatumNaloga(sqlDate);
		   nalog.setDatumValute(sqlDate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
  
	  try {

		File file = new File("generisanNalog.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Nalog.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(nalog, file);
		jaxbMarshaller.marshal(nalog, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
	}
	///ovako kreirani nalog bi trebao da se posalje banci preko SOAP-a
	//ili kao xml nalog ili obicni objekat
	@PostMapping(path = "/sendNalog")
	@ResponseStatus(HttpStatus.CREATED)
	public Nalog sendNalog(@RequestBody Faktura faktura){
		System.out.println("sendNalog "+faktura.getZaglavljeFakture().getNazivKupca());
		Nalog nalog = new Nalog();
		String uniqueID = UUID.randomUUID().toString();
		System.out.println(uniqueID);
		nalog.setIdPoruke(uniqueID);
		nalog.setDuznik(faktura.getZaglavljeFakture().getNazivKupca());
		nalog.setSvrhaPlacanja("prodaja");
		nalog.setPrimalac(faktura.getZaglavljeFakture().getNazivDobavljaca());
		nalog.setDatumNaloga(faktura.getZaglavljeFakture().getDatumRacuna());
		nalog.setDatumValute(faktura.getZaglavljeFakture().getDatumValute());
		Firma duznik = firmaService.findByPIB(faktura.getZaglavljeFakture().getPibKupca());
		System.out.println(duznik.getBrojRacuna());
		nalog.setRacunDuznika(duznik.getBrojRacuna());
		nalog.setModelZaduzenja(BigInteger.valueOf(97L));
		nalog.setPozivNaBrojZaduzenja("11111111111111111111");
		nalog.setRacunPrimaoca(faktura.getZaglavljeFakture().getUplataNaRacun());
		nalog.setModelOdobrenja(BigInteger.valueOf(97L));
		nalog.setPozivNaBrojOdobrenja("22222222222222222222");
		nalog.setIznos(faktura.getZaglavljeFakture().getIznosZaUplatu());
		nalog.setOznakaValute(faktura.getZaglavljeFakture().getOznakaValute());
		//ako je vece od 250000 postavi da je nalog hitan
		if(nalog.getIznos().compareTo(BigDecimal.valueOf(250000L))>1){
			nalog.setHitno(true);
		}else{
			nalog.setHitno(false);
		}
		return nalogService.save(nalog);
	}
	
}

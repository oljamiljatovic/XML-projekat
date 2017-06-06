package com.example.demo.faktura;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.SAXException;

import com.example.demo.model.MyValidationEventHandler;
import com.example.demo.stavkaFakture.StavkaFakture;
import com.example.demo.stavkaFakture.StavkaFaktureService;
import com.example.demo.zaglavljeFakture.ZaglavljeFakture;
import com.example.demo.zaglavljeFakture.ZaglavljeFaktureService;


@RestController
@RequestMapping("/faktura")
public class FakturaController {

	private final FakturaService fakturaService;
	private final ZaglavljeFaktureService zaglavljeFaktureService;
	private final StavkaFaktureService stavkaFaktureService;
	
	@Autowired
	public FakturaController(final FakturaService fakturaService,final ZaglavljeFaktureService zaglavljeFaktureService,final StavkaFaktureService stavkaFaktureService){
		this.fakturaService = fakturaService;
		this.zaglavljeFaktureService = zaglavljeFaktureService;
		this.stavkaFaktureService = stavkaFaktureService;

	}
	
	

	@GetMapping("/getFakturaXml")
	@ResponseStatus(HttpStatus.OK)
	public void getXml() {
		try {
			File file = new File("C:\\faktura.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Faktura.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller(); //unmarshaller
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = null;
			try {
				schema = schemaFactory.newSchema(new File("C:\\faktura.xsd"));
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jaxbUnmarshaller.setSchema(schema);
			jaxbUnmarshaller.setEventHandler(new MyValidationEventHandler());
			
			Faktura faktura = (Faktura) jaxbUnmarshaller.unmarshal(file);
			fakturaService.save(faktura);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
	
	@GetMapping("/makeFakturaXml")
	@ResponseStatus(HttpStatus.OK)
	public void makeXml() {
		
	  ZaglavljeFakture zaglavlje = new ZaglavljeFakture();
	  zaglavlje.setNazivDobavljaca("Dobavljac 222");
	  zaglavlje.setAdresaDobavljaca("adresa dobavljaca 111");
	  zaglavlje.setPibDobavljaca("14785236987");
	  zaglavlje.setNazivKupca("Kupac 123");
	  zaglavlje.setAdresaKupca("adresa kupca 123");
	  zaglavlje.setPibKupca("12365478965");
	  zaglavlje.setBrojRacuna(BigInteger.valueOf(147852));
	  
	   
	try {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsed = null;
		parsed = format.parse("2011-02-10");
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
		   zaglavlje.setDatumRacuna(sqlDate);
		   zaglavlje.setDatumValute(sqlDate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
       
	   
	   
	   
	   zaglavlje.setVrednostRobe(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   zaglavlje.setVrednostUsluga(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   zaglavlje.setUkupnoRobaIUsluge(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   zaglavlje.setUkupanRabat(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   zaglavlje.setUkupanPorez(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   zaglavlje.setOznakaValute("rsd");
	   zaglavlje.setIznosZaUplatu(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   zaglavlje.setUplataNaRacun("181818181818181818");
	   
	    
	   StavkaFakture stavka = new StavkaFakture();
	   stavka.setRedniBroj(BigInteger.valueOf(123));
	   stavka.setNazivRobeIliUsluge("roba1");
	   stavka.setKolicina(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   stavka.setJedinicaMere("kg");
	   
	   
	   
	   stavka.setJedinicnaCena(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   stavka.setVrednost(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   stavka.setProcenatRabata(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   stavka.setIznosRabata(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   stavka.setUmanjenoZaRabat(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   stavka.setUkupanPorez(new BigDecimal(12.23).setScale(2, RoundingMode.CEILING));
	   
	   
	   
	   StavkaFakture stavka2 = new StavkaFakture();
	   stavka2.setRedniBroj(BigInteger.valueOf(258));
	   stavka2.setNazivRobeIliUsluge("roba2");
	   stavka2.setKolicina(new BigDecimal(13.23).setScale(2, RoundingMode.CEILING));
	   stavka2.setJedinicaMere("kg");
	   
	   
	   
	   stavka2.setJedinicnaCena(new BigDecimal(125.36).setScale(2, RoundingMode.CEILING));
	   stavka2.setVrednost(new BigDecimal(26.85).setScale(2, RoundingMode.CEILING));
	   stavka2.setProcenatRabata(new BigDecimal(888.23).setScale(2, RoundingMode.CEILING));
	   stavka2.setIznosRabata(new BigDecimal(369.23).setScale(2, RoundingMode.CEILING));
	   stavka2.setUmanjenoZaRabat(new BigDecimal(52.85).setScale(2, RoundingMode.CEILING));
	   stavka2.setUkupanPorez(new BigDecimal(125.6).setScale(2, RoundingMode.CEILING));
	   
	   
	   
	   Faktura faktura = new Faktura();
	   faktura.setZaglavljeFakture(zaglavlje);
	   faktura.getStavkaFakture().add(stavka);
	   faktura.getStavkaFakture().add(stavka2);
	  

	  try {

		File file = new File("generisanaFaktura.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Faktura.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(faktura, file);
		jaxbMarshaller.marshal(faktura, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
	}
	@PostMapping(path = "/{idZaglavlja}")
	@ResponseStatus(HttpStatus.CREATED)
	public Faktura save(@PathVariable Long idZaglavlja,@RequestBody StavkaFakture stavkaFakture) {
		System.out.println(idZaglavlja+"   "+stavkaFakture.getNazivRobeIliUsluge());
		ZaglavljeFakture zaglavljeFakture = zaglavljeFaktureService.findOne(idZaglavlja);
		StavkaFakture sacuvanaSF = stavkaFaktureService.save(stavkaFakture);
		Faktura postojecaFaktura = fakturaService.findByZaglavljeFakture_Id(idZaglavlja);
		Faktura savedFaktura = null;
		if(postojecaFaktura==null){
			Faktura faktura= new Faktura();
			faktura.setZaglavljeFakture(zaglavljeFakture);
			stavkaFakture.setRedniBroj(BigInteger.valueOf(1L));
			List<StavkaFakture> stavke = new ArrayList<StavkaFakture>();
			stavke.add(stavkaFakture);
			faktura.setStavkaFakture(stavke);
			savedFaktura=fakturaService.save(faktura);
		}else{
			BigInteger redniBroj = BigInteger.valueOf(postojecaFaktura.getStavkaFakture().size()+1);
			System.out.println("redniBroj = "+redniBroj);
			stavkaFakture.setRedniBroj(redniBroj);
			postojecaFaktura.getStavkaFakture().add(stavkaFakture);
			savedFaktura= fakturaService.save(postojecaFaktura);
		}
		sendFaktura(savedFaktura);
		return savedFaktura;
	}
	
	@GetMapping(path = "/findAllFaktura")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Faktura> findAllFaktura() {
		return fakturaService.findAll();
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public String sayHelloXML(){
		String response = "<?xml version='1.0'?><hello>HELLO</hello>";
		return response;
	}
	
	//REST Client Code
	private static void sendFaktura(Faktura faktura)
	{
	    final String uri = "http://localhost:8081/RESTApi/faktura";
	    System.out.println("///sendFaktura");
	    RestTemplate restTemplate = new RestTemplate();
	    Faktura result = restTemplate.postForObject( uri,faktura, Faktura.class);
	 
	    System.out.println(result);
	}
	
}




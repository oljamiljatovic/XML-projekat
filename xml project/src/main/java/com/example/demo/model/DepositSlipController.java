package com.example.demo.model;

import java.io.File;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.bind.Unmarshaller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/depositSlip")
public class DepositSlipController{
	private final DepositSlipService depositSlipService;
	
	@Autowired
	public DepositSlipController(final DepositSlipService depositSlipService){
		this.depositSlipService = depositSlipService;
	}
	
	
	@GetMapping("/getXml")
	@ResponseStatus(HttpStatus.OK)
	public void getXml() {
		try {

			File file = new File("C:\\depositSlip.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(DepositSlipXml.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			
			DepositSlipXml customer = (DepositSlipXml) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer.getCodeOfCurrency());
			
			
			
		/*	DepositSlip deposit = new DepositSlip();
			
			java.util.Date datum = (customer.getCurrencyDate().toGregorianCalendar().getTime());
			java.sql.Date sqlDt = new java.sql.Date(datum.getTime());
			deposit.setCurrencyDate(sqlDt);
			
			
			java.util.Date depositDate = (customer.getDepositSlipDate().toGregorianCalendar().getTime());
			java.sql.Date sqlDepositDate = new java.sql.Date(depositDate.getTime());
			deposit.setDepositSlipDate(sqlDepositDate);
			
			
			
			
			deposit.setDeptor(customer.getDeptor());
			deposit.setReceiver(customer.getReceiver());
			deposit.setBillOfDeptor(customer.getBillOfDeptor());
			deposit.setCodeOfCurrency(customer.getCodeOfCurrency()); 
			deposit.setBillOfReceiver(customer.getBillOfReceiver());
			deposit.setDirection(customer.isDirection());
			deposit.setUrgently(customer.isUrgently());
			deposit.setPurposeOfPayment(customer.getPurposeOfPayment());
			deposit.setModelAssignment(customer.getModelAssignment());
			deposit.setModelApproval(customer.getModelApproval());
			
			deposit.setReferenceNumberApproval(customer.getReferenceNumberApproval());
			deposit.setReferenceNumberAssignment(customer.getReferenceNumberAssignment());
			deposit.setAmount(customer.getAmount());
			
			
			
			depositSlipService.save(deposit);
			*/
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
	
	/*@GetMapping("/makeXml")
	@ResponseStatus(HttpStatus.OK)
	public void makeXml() {
		
		//DepositSlip dp = depositSlipService.findOne(1);
	  DepositSlipXml deposit = new DepositSlipXml();
	  
	  
	  Date date = new Date();
	  XMLGregorianCalendar xmlDate = null;
	  GregorianCalendar gc = new GregorianCalendar();

	  gc.setTime(date);

	  try{
	      xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	  }
	  catch(Exception e){
	      e.printStackTrace();
	  }


		deposit.setCurrencyDate(xmlDate);
		deposit.setDepositSlipDate(xmlDate);
		deposit.setDeptor("Deptor 1");
		deposit.setReceiver("Receiver 1");
		deposit.setBillOfDeptor("12364");
		deposit.setCodeOfCurrency("rsd"); 
		deposit.setBillOfReceiver("558852");
		deposit.setDirection(true);
		deposit.setUrgently(false);
		deposit.setPurposeOfPayment("Svrha");
		deposit.setModelAssignment(12);
		deposit.setModelApproval(85);
		
		deposit.setReferenceNumberApproval("554744125");
		deposit.setReferenceNumberAssignment("5415451213");
		deposit.setAmount(7521);
		
	 

	  try {

		File file = new File("newDepositSlip.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(DepositSlipXml.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(deposit, file);
		jaxbMarshaller.marshal(deposit, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
	}*/
}

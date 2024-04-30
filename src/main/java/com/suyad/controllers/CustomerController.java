package com.suyad.controllers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suyad.Bindings.AddressClass;
import com.suyad.Bindings.Customer;

@Controller
public class CustomerController 
{
	@Autowired
	Customer c;
	@Autowired
	AddressClass a;
	@GetMapping("/marshel")
	@ResponseBody
	public String XmlConverter()
	{
		a.setCity("Khamanon");
		a.setState("Punjab");
		a.setCountry("India");
		c.setId(10);
		c.setName("Suyadpreet Singh");
		c.setEmail("Suyadpreet@gmail.com");
		c.setPhno(95015L);
		c.setAddr(a);
		
		try 
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller createMarshaller = jaxbContext.createMarshaller();
			createMarshaller.marshal(c, new File("Customer.xml"));
			System.out.println("File has been Created .........");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "XML File Has been created Successfully..........";
	}
	@GetMapping("/unmarshel")
	@ResponseBody
	public Customer XmlConverterToJava()
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Object unmarshal = unmarshaller.unmarshal(new File("Customer.xml"));
			c = (Customer) unmarshal;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return c;
	}
}

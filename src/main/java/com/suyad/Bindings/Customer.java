package com.suyad.Bindings;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;


import lombok.Data;

@Data
@Component
@XmlRootElement
public class Customer 
{
	private Integer Id;
	private String name;
	private String email;
	private Long phno;
	private AddressClass addr;
}

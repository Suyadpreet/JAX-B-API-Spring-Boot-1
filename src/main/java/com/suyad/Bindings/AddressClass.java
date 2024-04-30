package com.suyad.Bindings;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AddressClass 
{
	private String city;
	private String State;
	private String country;
}

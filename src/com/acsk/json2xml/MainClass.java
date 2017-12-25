package com.acsk.json2xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;

public class MainClass {
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		String json = "{'id' : 1, 'name' : 'chandrakant', 'age' : '24', 'salary' : 100000, 'address' : 'pune'}";
		
		Gson gson = new Gson();
		Employee employee = gson.fromJson(json, Employee.class);
		
		System.out.println(employee);
		
		JAXBContext context = JAXBContext.newInstance(Employee.class);
		
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(employee, new FileOutputStream("json2xml.xml"));

	}

}

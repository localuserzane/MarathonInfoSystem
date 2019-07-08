package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Marathon;
import com.example.demo.repo.MarathonRepo;

@Controller
public class MarController {

	@Autowired
	MarathonRepo marRepo;
	
	@GetMapping(value="/testmar")
	public String teststud()
	{
		LocalDate today = LocalDate.now();
		Marathon mar1=new Marathon("Bigbank",45,"Saldus",today, today);
		Marathon mar2=new Marathon("TET",36,"Riga",today, today);
		//save into the database using repo
		marRepo.save(mar1);
		marRepo.save(mar2);
	
	return "testmar";
	}
	
}

package com.example.demo.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Marathon;
import com.example.demo.repo.MarathonRepo;
import com.example.demo.services.MarathonServicesImpl;

@Controller
@RequestMapping(value = "/a")
public class MarController {
	@Autowired
	MarathonServicesImpl marathonServicesImpl;
	@Autowired
	MarathonRepo marathonRepo;
	
	@GetMapping(value = "/view-mar")
	public String viewmar(Model model) {
		model.addAttribute("object", marathonServicesImpl.selectAll());
	return "view-mar";
	}
	
	@GetMapping(value = "/add-marathon")
	public String addmar(Marathon marathon)
	{
		return "add-marathon";
	}
	
	@PostMapping(value = "/add-marathon")
	public String addmarPost(@Valid Marathon marathon, BindingResult result)
	{
		if(result.hasErrors())
			return "view-mar";
		else
		{
		marathonServicesImpl.insertNewMarathon(marathon);
		return "redirect:/a/view-mar";
		}
	}
	
	@GetMapping(value="/tesmar")
	public String testdata()
	{
		Marathon mar1=new Marathon("TET",30, "Riga", 121,111);
		Marathon mar2=new Marathon("SEB",40, "Sigulda",101,101);
		//save into the database using repo
		marathonRepo.save(mar1);
		marathonRepo.save(mar2);
		return "testmar";
	}
}

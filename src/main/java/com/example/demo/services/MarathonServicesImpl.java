package com.example.demo.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Marathon;
import com.example.demo.repo.MarathonRepo;


public class MarathonServicesImpl {

	@Override
	public boolean insertNewMarathon(Marathon marathon) {
		
		if(marathon==null)
			return false;
		if(MarathonRepo.existsById(marathon.getId()))
			return false;
		else
		{	
			MarathonRepo.save(marathon);
			return true;
		}
	}
/*
	@Autowired
	MarathonRepo marRepo;
	@Override
	public ArrayList<Marathon> selectAll() {
		
		return (ArrayList<Marathon>) marRepo.findAll();
	}

	//@Override
	public Marathon selectById(Long id) {
		Marathon marTemp=marRepo.findById(id).get();
		if(marTemp!=null)
		{
			return marTemp;
		}
		return null;
	}

	@Override
	public boolean updateMarathonById(Marathon marathon, Long id) {
		
		Marathon martmp=marRepo.findById(id).get();
		if(marRepo.existsById(id) && martmp!=null)
		{	
			martmp.setColor(marathon.getDate());
			martmp.setEngine(marathon.getTime());
			marRepo.save(martmp);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMarathonById(Long id) {
		
		if(marRepo.existsById(id))
		{
			Marathon marr = marRepo.findById(id).get();
			marRepo.delete(marr);
			return true;
		}
		return false;
	}
*/
}

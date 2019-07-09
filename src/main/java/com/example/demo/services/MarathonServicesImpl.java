package com.example.demo.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Marathon;
import com.example.demo.repo.MarathonRepo;

@Service
public class MarathonServicesImpl implements MarathonServices{

	@Autowired
	MarathonRepo marathonRepo;
	
	@Override
	public boolean insertNewMarathon(Marathon marathon) {

		if (marathon==null)
			return false;
		if(marathonRepo.existsById(marathon.getId_mar()))
			return false;
		else
		{	
			marathonRepo.save(marathon);
			return true;
		}
		}

	@Override
	public ArrayList<Marathon> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Marathon> tempList = new ArrayList<Marathon>();
		for (Marathon m:marathonRepo.findAll())
		{
			tempList.add(m);
		}
		return tempList;
	}

	@Override
	public Marathon selectById(Long id) {
		// TODO Auto-generated method stub
		if (id >=0) {
			Marathon marTemp = marathonRepo.findById(id).get();
			
			if(marTemp!=null)
				return marTemp;
			}
		return null;
	}

	@Override
	public boolean updateMarathonById(Marathon marathon, Long id) {
		// TODO Auto-generated method stub
		if (marathonRepo.existsById(id) && marathon!=null) {
			Marathon marTemp = marathonRepo.findById(id).get();
			marTemp.setName(marathon.getName());
			marTemp.setDistance(marathon.getDistance());
			marTemp.setPlace(marathon.getPlace());
			marathonRepo.save(marathon);
			return true;
		}
		return false;
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

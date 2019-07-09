package com.example.demo.services;
import java.util.ArrayList;
import com.example.demo.model.Marathon;

public interface MarathonServices {

	boolean insertNewMarathon(Marathon marathon);
	ArrayList<Marathon> selectAll();
	Marathon selectById(Long id);
	boolean updateMarathonById(Marathon marathon,Long id);
	
	//boolean deleteMarathonById(Long id);

	
}

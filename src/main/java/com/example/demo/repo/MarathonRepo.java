package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Marathon;
import com.example.demo.model.Organizer;

public interface MarathonRepo extends CrudRepository<Marathon, Long>{
	//ArrayList<Marathon> findById(Long id_mar);
}

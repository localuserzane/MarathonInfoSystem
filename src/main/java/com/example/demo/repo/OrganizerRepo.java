package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Organizer;

public interface OrganizerRepo extends CrudRepository<Organizer, Long>{
	ArrayList<Organizer> findByName(String name);
	//ArrayList<Organizer> findById(long id_org);

}

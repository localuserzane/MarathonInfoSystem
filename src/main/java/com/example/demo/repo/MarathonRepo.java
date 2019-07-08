package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Marathon;

public interface MarathonRepo extends CrudRepository<Marathon, Long>{
	
}

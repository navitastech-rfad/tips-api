package com.navitas.rfad.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitas.rfad.model.entity.Tips;

public interface TipsRepository extends CrudRepository<Tips, Integer> {
	
	 @Query(value = "SELECT * FROM TIPS WHERE TIPS_ID = ?1", nativeQuery = true)
	 Optional<Tips> findById(Integer caseId);
	  
}

package com.navitas.rfad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.navitas.rfad.model.CaseApiModel;

public interface CaseApiRepository extends CrudRepository<CaseApiModel, Integer> {
	
	  @Query(value = "SELECT * FROM CASE_INFO WHERE CASE_ID = ?1", nativeQuery = true)
	  Optional<CaseApiModel> findById(Integer caseId);

}

package com.navitas.rfad.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.navitas.rfad.model.entity.TipsFraudReport;

@Repository
public interface TipsFraudReportRepository extends CrudRepository<TipsFraudReport, Integer> {

}

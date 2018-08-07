package com.navitas.rfad.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitas.rfad.model.entity.TipsFraudReport;
import com.navitas.rfad.model.repository.TipsFraudReportRepository;

@Service
public class TipsFraudReportService {

	@Autowired
	TipsFraudReportRepository tipsFraudReportRepository;
	
	List<TipsFraudReport >getAllFraudReports() {
		Iterable<TipsFraudReport> allFraudReports = tipsFraudReportRepository.findAll();
		
		List<TipsFraudReport> result = StreamSupport
				.stream(allFraudReports.spliterator(), false)
			    .collect(Collectors.toList());			
			
		return result;
	}
	
	TipsFraudReport getFraudReportById(Integer reportId) {
		Optional<TipsFraudReport> tipsFraudReport =  tipsFraudReportRepository.findById(reportId);
		return tipsFraudReport.get();
	}
}

package com.navitas.rfad.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navitas.rfad.model.repository.TipsFraudReportRepository;

@Service
public class TipsFraudReportService {

	@Autowired
	TipsFraudReportRepository tipsFraudReportRepository;
}

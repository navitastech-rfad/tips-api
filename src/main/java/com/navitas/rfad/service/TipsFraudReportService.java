package com.navitas.rfad.service;

import com.navitas.rfad.bean.TipsFraudReport;
import com.navitas.rfad.model.entity.Tips;
import com.navitas.rfad.model.repository.TipsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipsFraudReportService {

  @Autowired TipsRepository tipsRepo;

  public List<TipsFraudReport> getAllFraudReports() {
    final Iterable<Tips> allFraudReports = tipsRepo.findAll();

    final List<TipsFraudReport> result =
        StreamSupport.stream(allFraudReports.spliterator(), false).collect(Collectors.toList());

    return result;
  }

  TipsFraudReport getFraudReportById(Integer reportId) {
    final Optional<TipsFraudReport> tipsFraudReport = tipsRepo.findById(reportId);
    return tipsFraudReport.get();
  }
}

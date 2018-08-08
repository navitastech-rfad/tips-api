package com.navitas.rfad.service;

import com.navitas.rfad.bean.TipsFraudReport;
import com.navitas.rfad.model.entity.Tips;
import com.navitas.rfad.model.repository.TipsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TipsFraudReportService {
  @Inject private TipsRepository tipsRepo;

  public List<TipsFraudReport> getAllFraudReports() {
    final Iterable<Tips> allFraudReports = tipsRepo.findAll();

    final List<TipsFraudReport> result =
        StreamSupport.stream(allFraudReports.spliterator(), false)
            .map(TipsFraudReport::new)
            .collect(Collectors.toList());

    return result;
  }

  public TipsFraudReport getFraudReportById(String reportId) {
    final Optional<Tips> tip = tipsRepo.findById(UUID.fromString(reportId));

    return new TipsFraudReport(tip.get());
  }

  public TipsFraudReport updateService(TipsFraudReport updatedCase) {
    final Optional<Tips> entity = tipsRepo.findById(updatedCase.getId());

    if (entity.isPresent()) {
      final Tips tips = entity.get();
      tips.setComment(updatedCase.getComment());
      tips.setCompany(updatedCase.getEntity());
      tips.setStatus(updatedCase.getStatus());
      tipsRepo.save(tips);
      return updatedCase;
    } else {
      throw new RuntimeException();
    }
  }
}

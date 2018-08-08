package com.navitas.rfad.service;

import com.navitas.rfad.bean.TipsFraudReport;
import com.navitas.rfad.model.entity.Tips;
import com.navitas.rfad.model.repository.TipsRepository;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CaseService {
  @Inject private TipsRepository tipsRepo;

  public Tips updateService(TipsFraudReport updatedCase) {
    final Optional<Tips> tip = tipsRepo.findById(updatedCase.getId());
  }
}

package com.navitas.rfad.service;

import com.navitas.rfad.model.entity.Tips;
import com.navitas.rfad.model.repository.TipsRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CaseService {
  @Inject private TipsRepository tipsRepo;

  public Tips updateService(Tips updatedCase) {
    final Optional<Tips> tip = tipsRepo.findById(updatedCase.getId());
  }
}

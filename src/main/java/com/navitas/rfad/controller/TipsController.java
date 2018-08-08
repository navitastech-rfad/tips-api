package com.navitas.rfad.controller;

import com.navitas.rfad.bean.TipsFraudReport;
import com.navitas.rfad.model.entity.Tips;
import com.navitas.rfad.model.repository.TipsRepository;
import com.navitas.rfad.service.TipsFraudReportService;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipsController extends BaseController {

  @Inject private TipsRepository tipsRepository;

  @Inject private TipsFraudReportService tipsFraudReportService;

  @PostMapping(value = "/create")
  public ResponseEntity<Tips> create(@RequestBody Tips tips) {
        return new ResponseEntity<>(tipsRepository.save(tips), HttpStatus.CREATED);
    }

  @GetMapping
  //  @PreAuthorize("hasRole('user') or hasRole('admin')")
  public ResponseEntity<List<TipsFraudReport>> retrieve() {
        return new ResponseEntity<>(tipsFraudReportService.getAllFraudReports(), HttpStatus.OK);
    }

  @PutMapping(value = "/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TipsFraudReport> update(
      @PathVariable String caseId, @RequestBody TipsFraudReport tips) {
    try {
      if (!UUID.fromString(caseId).equals(tips.getId())) {
        return ResponseEntity.badRequest().build();
      }

      return ResponseEntity.ok(tipsFraudReportService.updateService(tips));
    } catch (final Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}

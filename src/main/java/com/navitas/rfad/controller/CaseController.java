package com.navitas.rfad.controller;

import com.navitas.rfad.model.entity.Tips;
import com.navitas.rfad.service.CaseService;

import java.util.UUID;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/tips/case")
public class CaseController {
  @Inject private CaseService caseService;

  @PutMapping(value = "/{caseId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Tips> create(@PathVariable String caseId, @RequestBody Tips tips) {
    try {
      if (!UUID.fromString(caseId).equals(tips.getId())) {
        return ResponseEntity.badRequest().build();
      }

      return new ResponseEntity<>(tipsRepository.save(tips), HttpStatus.CREATED);
    } catch (final Exception e) {
      return ResponseEntity.badRequest().build();
    }
    }
}

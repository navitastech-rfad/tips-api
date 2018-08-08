package com.navitas.rfad.bean;

import com.navitas.rfad.model.entity.Tips;

import java.util.UUID;

public class TipsFraudReport {
  private UUID id;

  private String entity;

  private String status;

  private String comment;

  public TipsFraudReport() {}

  public TipsFraudReport(Tips tips) {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEntity() {
    return entity;
  }

  public void setEntity(String entity) {
    this.entity = entity;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}

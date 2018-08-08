package com.navitas.rfad.model.entity;

import java.util.UUID;

//import javax.validation.constraints.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tips_info")
public class TipsFraudReport {


	private static final long serialVersionUID = 7659513807301586843L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tips_id", nullable = false)
	private UUID id;

	@Column(name = "entity", nullable = true)
	private String entity;

	@Column(name = "status", nullable = true)
	private String status;

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


}

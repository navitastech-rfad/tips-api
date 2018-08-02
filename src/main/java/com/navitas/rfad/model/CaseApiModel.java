package com.navitas.rfad.model;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="case_info")
public class CaseApiModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="case_id", nullable=false)
	private Integer caseId;
    
	@Column(name="title", nullable=false)
    private String caseTitle;
	
	@Column(name="benefit_applied")
	private String benefitApplied;
    
	@Column(name="created_by", nullable=false)
    private UUID createdBy;
    
	@Column(name="updated_by")
    private UUID updatedBy;
    
	@Column(name="first_name", nullable=false)
    private String firstName;
    
	@Column(name="last_name", nullable=false)
    private String lastName;
    
	@Column(name="city", nullable=false)
    private String city;
    
	@Column(name="address", nullable=false)
    private String address;
    
	@Column(name="state", nullable=false, length=2)
    private String state;
    
	@Column(name="created_date", nullable=false)
    private Timestamp createdDate;
    
	@Column(name="updated_date", nullable=false)
    private Timestamp updatedDate;
	
	public CaseApiModel() {}

	public CaseApiModel(String caseTitle, String benefitApplied, UUID createdBy, UUID updatedBy, String firstName,
			String lastName, String city, String address, String state) {
		super();
		this.caseTitle = caseTitle;
		this.benefitApplied = benefitApplied;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.address = address;
		this.state = state;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getCaseTitle() {
		return caseTitle;
	}

	public void setCaseTitle(String caseTitle) {
		this.caseTitle = caseTitle;
	}

	public String getBenefitApplied() {
		return benefitApplied;
	}

	public void setBenefitApplied(String benefitApplied) {
		this.benefitApplied = benefitApplied;
	}

	public UUID getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}

	public UUID getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(UUID updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "CaseApiModel [caseId=" + caseId + ", caseTitle=" + caseTitle + ", benefitApplied=" + benefitApplied
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", firstName=" + firstName + ", lastName="
				+ lastName + ", city=" + city + ", address=" + address + ", state=" + state + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
}

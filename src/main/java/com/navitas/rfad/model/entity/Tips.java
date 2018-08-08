package com.navitas.rfad.model.entity;

import java.sql.Timestamp;
import java.util.UUID;
import java.util.Objects;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
//import javax.validation.constraints.Pattern;

@Entity
@Table(name="tips_info")
public class Tips {
	
  private static final long serialVersionUID = 7659513807301586843L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="tips_id", nullable=false)
  private UUID id;

  @Column(name="email", nullable=true)
 // @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Must be a valid email: 'user@test.com'")
  private String email;

  @Column(name="first_name", nullable=true)
  private String firstName;
    
  @Column(name="last_name", nullable=true)
  private String lastName;
  
  @Column(name="phone", nullable=true)
  private String phone;
  
  @Column(name="description", nullable=false)
  private String description;
  
  @Column(name="created_date", nullable=true)
  private Timestamp createdDate;
    
  @Column(name="updated_date", nullable=true)
  private Timestamp updatedDate;
  
  @Column(name="company", nullable=true)
  private String company;
  
  @Column(name="status", nullable=true)
  private String status = "PROCESSED";
  
  @Column(name="analytical_output", nullable=true)
  private String analyticalOutput;
  
  @Column(name="tips_comment", nullable=true)
  private String comment = "PROCESSED";
  
  
  //@JsonInclude()
  @Transient 
  private MultipartFile file;
  
  
  public String getAnalyticalOutput() {
	  return this.analyticalOutput;
  }
  
  public void setAnalyticalOutput( String output ) {
	  this.analyticalOutput = output;
  }
  
  public String getComment(  ) {
	  return this.comment;
  }
  public void setComment( String comment ) {
	  this.comment = comment;
  }
  
  public MultipartFile getFile() {
	  return file;
  }
  
  public void setFile( MultipartFile file ) {
	  this.file = file;
  }
  
  public String getCompany() {
	  return this.company;
  }
  
  public void setCompany(String company ) {
	  this.company = company;
  }
  
  public String getStatus() {
	  return status;
  }
  
  
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
  
  
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj instanceof Tips) {
      final Tips other = (Tips) obj;
      return Objects.equals(id, other.getId()) || Objects.equals(description, other.getDescription());
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description);
  }
	
}

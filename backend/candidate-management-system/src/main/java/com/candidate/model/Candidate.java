package com.candidate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Candidate {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
   
private String status;
private String name;
private float experience;
private String noticePeriod;
private String primarySkills;
private String secondrySkills;
private long cell;
private String email;
private String location;
private String perviousCompany;
private double CTC;
private double ECTC;
private String mode;
private String education;
private String comment;
private String clientRound;

public Candidate() {
	
}

public Candidate(String status, String name, float experience, String noticePeriod, String primarySkills,
		String secondrySkills, int cell, String email, String location, String perviousCompany, double cTC, double eCTC,
		String mode, String education, String comment, String clientRound) {
	super();
	this.status = status;
	this.name = name;
	this.experience = experience;
	this.noticePeriod = noticePeriod;
	this.primarySkills = primarySkills;
	this.secondrySkills = secondrySkills;
	this.cell = cell;
	this.email = email;
	this.location = location;
	this.perviousCompany = perviousCompany;
	CTC = cTC;
	ECTC = eCTC;
	this.mode = mode;
	this.education = education;
	this.comment = comment;
	this.clientRound = clientRound;
}


public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getExperience() {
	return experience;
}
public void setExperience(float experience) {
	this.experience = experience;
}
public String getNoticePeriod() {
	return noticePeriod;
}
public void setNoticePeriod(String noticePeriod) {
	this.noticePeriod = noticePeriod;
}
public String getPrimarySkills() {
	return primarySkills;
}
public void setPrimarySkills(String primarySkills) {
	this.primarySkills = primarySkills;
}
public String getSecondrySkills() {
	return secondrySkills;
}
public void setSecondrySkills(String secondrySkills) {
	this.secondrySkills = secondrySkills;
}
public long getCell() {
	return cell;
}
public void setCell(long cell) {
	this.cell = cell;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getPerviousCompany() {
	return perviousCompany;
}
public void setPerviousCompany(String perviousCompany) {
	this.perviousCompany = perviousCompany;
}
public double getCTC() {
	return CTC;
}
public void setCTC(double cTC) {
	CTC = cTC;
}
public double getECTC() {
	return ECTC;
}
public void setECTC(double eCTC) {
	ECTC = eCTC;
}
public String getMode() {
	return mode;
}
public void setMode(String mode) {
	this.mode = mode;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public String getClientRound() {
	return clientRound;
}
public void setClientRound(String clientRound) {
	this.clientRound = clientRound;
}
}

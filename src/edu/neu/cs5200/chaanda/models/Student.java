package edu.neu.cs5200.chaanda.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("STU")
@PrimaryKeyJoinColumn(name="studentId")
public class Student extends Person{
	
	private Date yearOfStudy;
	private Date enrolledYear;
	private String IncomeProof;
	private boolean fundPetitionStatus;
	private float fundCollected;

	@ManyToOne
	private University university;
	
	@ManyToOne
	private Degree degree;
	
	
	public Date getYearOfStudy() {
		return yearOfStudy;
	}


	public void setYearOfStudy(Date yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}


	public Date getEnrolledYear() {
		return enrolledYear;
	}


	public void setEnrolledYear(Date enrolledYear) {
		this.enrolledYear = enrolledYear;
	}


	public String getIncomeProof() {
		return IncomeProof;
	}


	public void setIncomeProof(String incomeProof) {
		IncomeProof = incomeProof;
	}


	public boolean isFundPetitionStatus() {
		return fundPetitionStatus;
	}


	public void setFundPetitionStatus(boolean fundPetitionStatus) {
		this.fundPetitionStatus = fundPetitionStatus;
	}


	public float getFundCollected() {
		return fundCollected;
	}


	public void setFundCollected(float fundCollected) {
		this.fundCollected = fundCollected;
	}


	public University getUniversity() {
		return university;
	}


	public void setUniversity(University university) {
		this.university = university;
	}


	public Degree getDegree() {
		return degree;
	}


	public void setDegree(Degree degree) {
		this.degree = degree;
	}


	public Student(Date yearOfStudy, Date enrolledYear, String incomeProof,
			boolean fundPetitionStatus, float fundCollected,
			University university, Degree degree) {
		super();
		this.yearOfStudy = yearOfStudy;
		this.enrolledYear = enrolledYear;
		IncomeProof = incomeProof;
		this.fundPetitionStatus = fundPetitionStatus;
		this.fundCollected = fundCollected;
		this.university = university;
		this.degree = degree;
	}


	public Student() {
		super();
	}
	
	

}

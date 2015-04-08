package edu.neu.cs5200.chaanda.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class University {
	@Id
	private Integer universityId;
	private String universityName;
	
	@OneToOne
	private BankAccount universityBankAccount;
	
	@OneToOne
	private Address universityAddress;
	
	@OneToMany
	private List<Degree> degrees;
	
	@OneToMany
	private List<Student> students;
	
	
	public Integer getUniversityId() {
		return universityId;
	}


	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}


	public String getUniversityName() {
		return universityName;
	}


	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}


	public BankAccount getUniversityBankAccount() {
		return universityBankAccount;
	}


	public void setUniversityBankAccount(BankAccount universityBankAccount) {
		this.universityBankAccount = universityBankAccount;
	}


	public Address getUniversityAddress() {
		return universityAddress;
	}


	public void setUniversityAddress(Address universityAddress) {
		this.universityAddress = universityAddress;
	}


	public List<Degree> getDegrees() {
		return degrees;
	}


	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public University(Integer universityId, String universityName,
			BankAccount universityBankAccount, Address universityAddress,
			List<Degree> degrees, List<Student> students) {
		super();
		this.universityId = universityId;
		this.universityName = universityName;
		this.universityBankAccount = universityBankAccount;
		this.universityAddress = universityAddress;
		this.degrees = degrees;
		this.students = students;
	}


	public University() {
		super();
	}
}

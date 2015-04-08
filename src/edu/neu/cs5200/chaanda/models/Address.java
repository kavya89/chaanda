package edu.neu.cs5200.chaanda.models;

import javax.persistence.*;

@Entity
public class Address {	
	@Id
	private Integer addressId;
	private String street;
	private String city;
	private String state;
	private String country;
	
	@OneToOne
	private BankMaster bankMasterAddress;
	
	@OneToOne
	private University universityAddress;
	
	@OneToOne
	private Person person;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BankMaster getBankMasterAddress() {
		return bankMasterAddress;
	}

	public void setBankMasterAddress(BankMaster bankMasterAddress) {
		this.bankMasterAddress = bankMasterAddress;
	}

	public University getUniversityAddress() {
		return universityAddress;
	}

	public void setUniversityAddress(University universityAddress) {
		this.universityAddress = universityAddress;
	}

	public Address(Integer addressId, String street, String city, String state,
			String country, BankMaster bankMasterAddress,
			University universityAddress) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.bankMasterAddress = bankMasterAddress;
		this.universityAddress = universityAddress;
	}

	public Address() {
		super();
	}
	
	
}

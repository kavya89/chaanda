package edu.neu.cs5200.chaanda.models;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("DON")
@PrimaryKeyJoinColumn(name="donorId")
public class Donor extends Person{
	
	@OneToOne
	private BankAccount donorBankAccount;

	
	public BankAccount getDonorBankAccount() {
		return donorBankAccount;
	}


	public void setDonorBankAccount(BankAccount donorBankAccount) {
		this.donorBankAccount = donorBankAccount;
	}


	public Donor(BankAccount donorBankAccount) {
		super();
		this.donorBankAccount = donorBankAccount;
	}


	public Donor() {
		super();
	}
	
	

}

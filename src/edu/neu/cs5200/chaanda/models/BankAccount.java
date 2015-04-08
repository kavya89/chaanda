package edu.neu.cs5200.chaanda.models;

import java.util.Date;

import javax.persistence.*;

@Entity
public class BankAccount {
	@Id
	private Integer idBankAccount;
	private Integer accountNumber;
	private Integer cvv;
	private Date expireDate;
	private Integer pin;
	private String accountHolderName;
	private String accountHolderEmail;
	
	@ManyToOne
	private BankMaster bankMaster;

	@OneToOne
	private University uniBankAccount;
	
	@OneToOne
	private Donor donorBankAccount;

	public Integer getIdBankAccount() {
		return idBankAccount;
	}

	public void setIdBankAccount(Integer idBankAccount) {
		this.idBankAccount = idBankAccount;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountHolderEmail() {
		return accountHolderEmail;
	}

	public void setAccountHolderEmail(String accountHolderEmail) {
		this.accountHolderEmail = accountHolderEmail;
	}

	public BankMaster getBankMaster() {
		return bankMaster;
	}

	public void setBankMaster(BankMaster bankMaster) {
		this.bankMaster = bankMaster;
	}

	public University getUniBankAccount() {
		return uniBankAccount;
	}

	public void setUniBankAccount(University uniBankAccount) {
		this.uniBankAccount = uniBankAccount;
	}

	public Donor getDonorBankAccount() {
		return donorBankAccount;
	}

	public void setDonorBankAccount(Donor donorBankAccount) {
		this.donorBankAccount = donorBankAccount;
	}

	public BankAccount(Integer idBankAccount, Integer accountNumber,
			Integer cvv, Date expireDate, Integer pin,
			String accountHolderName, String accountHolderEmail,
			BankMaster bankMaster, University uniBankAccount,
			Donor donorBankAccount) {
		super();
		this.idBankAccount = idBankAccount;
		this.accountNumber = accountNumber;
		this.cvv = cvv;
		this.expireDate = expireDate;
		this.pin = pin;
		this.accountHolderName = accountHolderName;
		this.accountHolderEmail = accountHolderEmail;
		this.bankMaster = bankMaster;
		this.uniBankAccount = uniBankAccount;
		this.donorBankAccount = donorBankAccount;
	}

	public BankAccount() {
		super();
	}
	
	
}

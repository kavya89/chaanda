package edu.neu.cs5200.chaanda.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class BankMaster {
	
	@Id
	private Integer bankId;
	private String bankName;
	private String bankSwiftCode;
	private String bankRouting;
	
	@OneToOne
	private Address bankAddress;
	
	@OneToMany
	private List<BankAccount> bankAccounts;

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankSwiftCode() {
		return bankSwiftCode;
	}

	public void setBankSwiftCode(String bankSwiftCode) {
		this.bankSwiftCode = bankSwiftCode;
	}

	public String getBankRouting() {
		return bankRouting;
	}

	public void setBankRouting(String bankRouting) {
		this.bankRouting = bankRouting;
	}

	public Address getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(Address bankAddress) {
		this.bankAddress = bankAddress;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public BankMaster(Integer bankId, String bankName, String bankSwiftCode,
			String bankRouting, Address bankAddress,
			List<BankAccount> bankAccounts) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.bankSwiftCode = bankSwiftCode;
		this.bankRouting = bankRouting;
		this.bankAddress = bankAddress;
		this.bankAccounts = bankAccounts;
	}

	public BankMaster() {
		super();
	}
	
	
}

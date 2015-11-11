package edu.neu.cs5200.chaanda.models;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int studentId;

	@Temporal(TemporalType.DATE)
	private Date enrolledYear;

	private BigDecimal familyIncome;

	private BigDecimal gpa;

	//bi-directional many-to-one association to Degree
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="degreeId")
	private Degree degree;

	//bi-directional one-to-one association to Studentfunddetail
	@OneToOne(mappedBy="student")
	private Studentfunddetail studentfunddetail;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="student")
	private List<Transaction> transactions;
	
	//bi-directional one-to-one association to Person
	@OneToOne(fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn(name="studentId", referencedColumnName="personId")
	private Person person;

	public Student() {
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getEnrolledYear() {
		return this.enrolledYear;
	}

	public void setEnrolledYear(Date enrolledYear) {
		this.enrolledYear = enrolledYear;
	}

	public BigDecimal getFamilyIncome() {
		return this.familyIncome;
	}

	public void setFamilyIncome(BigDecimal familyIncome) {
		this.familyIncome = familyIncome;
	}

	public BigDecimal getGpa() {
		return this.gpa;
	}

	public void setGpa(BigDecimal gpa) {
		this.gpa = gpa;
	}

	public Degree getDegree() {
		return this.degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public Studentfunddetail getStudentfunddetail() {
		return this.studentfunddetail;
	}

	public void setStudentfunddetail(Studentfunddetail studentfunddetail) {
		this.studentfunddetail = studentfunddetail;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setStudent(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setStudent(null);

		return transaction;
	}
	
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
package edu.neu.cs5200.chaanda.models;

import javax.persistence.*;

@Entity
public class Role {
	@Id
	private Integer roleId;
	private String roleName;
	
	@OneToOne
	private Person person;
	
	
	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	
	public Role(Integer roleId, String roleName, Person person) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.person = person;
	}


	public Role() {
		super();
	}
	
	

}

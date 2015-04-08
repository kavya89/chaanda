package edu.neu.cs5200.chaanda.dao;

import javax.persistence.*;

import edu.neu.cs5200.chaanda.models.Person;


public class StudentDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("chaanda");
	EntityManager em = factory.createEntityManager();
	
	//student login
	private boolean universityLogin(String userName , String password){
		boolean loginStatus = false;
		
		Person p = em.find(Person.class, userName);
		
		if(p.getPassword() == password){
			loginStatus = true;
		}
		
		return loginStatus;
		
	}
	
	public static void main(String[] args){
		StudentDAO dao = new StudentDAO();
		
		boolean loginStatus = dao.universityLogin("kavya89", "#Kavya123");
		
		System.out.println(loginStatus);
	}

}

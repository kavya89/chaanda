package edu.neu.cs5200.chaanda.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.neu.cs5200.chaanda.models.Degree;

public class DegreeDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("chaanda_local");
	EntityManager em = null;

	public void createStudent(Degree degree) 
	{
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(degree);
		
		em.getTransaction().commit();
		em.close();
		
	}
}

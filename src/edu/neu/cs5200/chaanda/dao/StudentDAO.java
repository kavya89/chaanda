package edu.neu.cs5200.chaanda.dao;

import java.io.File;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import edu.neu.cs5200.chaanda.models.*;


public class StudentDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("chaanda_local");
	EntityManager em = null;

	//student login
	public Person universityLogin(String userName , String password){

		em = factory.createEntityManager();

		Person p = null;

		try{
			p = (Person) em.createQuery(
					"SELECT p FROM Person p WHERE p.userName = :name")
					.setParameter("name", userName)
					.getSingleResult();

			if(p.getPassword().equals(password)){
				return p;
			}
			else{
				return null;
			}
			
		}

		catch(NoResultException e){
			return null;
		}
		finally{
			em.close();
			
		}
	}


	//Fill and edit form
	public Student filForm(Student student){

		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(student);
		em.getTransaction().commit();
		em.close();

		return student;
	}

	//Get student details for student landing page
	public Student getStudentDetailsForStudentLandingPage(Integer studentId){

		em = factory.createEntityManager();
		return em.find(Student.class, studentId);
	}	

	//get tuition fee of student
	public Degree getTuitionFee(Integer degreeId){
		return em.find(Degree.class, degreeId);

	}

	// get students who are waiting for approval
	@SuppressWarnings("unchecked")
	public List<Student> getStudentsWaiting(Integer universityId) {

        em = factory.createEntityManager();

        String query = "SELECT s FROM Student s, University u "
                + "WHERE s.studentfunddetail.fundPetitionStatus = 1 "
                + "AND s.degree.college.university.universityId = u.universityId "
                + "AND u.universityId = " + universityId;

        return em.createQuery(query).getResultList();
    }

	// get students with fund request approved
	@SuppressWarnings("unchecked")
	public List<Student> getStudentsApproved(Integer universityId) {
        em = factory.createEntityManager();

        String query = "SELECT s FROM Student s, University u "
                + "WHERE s.studentfunddetail.fundPetitionStatus = 2 "
                + "AND s.degree.college.university.universityId = u.universityId "
                + "AND u.universityId = " + universityId;

        return em.createQuery(query).getResultList();
    }

	// get students who are waiting for approval
	public void updateStudent(int studentId, Student student) {

		em = factory.createEntityManager();
		em.getTransaction().begin();

		student.setStudentId(studentId);
		em.merge(student);

		em.getTransaction().commit();
		em.close();
	}

	//get student wanting funds, from a the selected university
	@SuppressWarnings("unchecked")
	public List<Student> getStudentFromUni(String universityName) {

		em = factory.createEntityManager();
		String query = "SELECT s FROM Student s, University u WHERE s.degree.college.university.universityId = u.universityId AND  "
				+ "u.universityName LIKE '%"
				+ universityName
				+ "%'";
		return em.createQuery(query).getResultList();
	}

	// get students who need funding
	@SuppressWarnings("unchecked")
	public List<Student> getStudentsWantingFund() {

		em = factory.createEntityManager();
		String query = "SELECT s FROM Student s, University u  WHERE s.degree.college.university.universityId = u.universityId AND u.registered = 1";
		return em.createQuery(query).getResultList();
	}

	//Exports the student to an xml file.
	public void exportStudentDatabaseToXmlFile(Address address, String xmlFileName) 
	{
		try 
		{
			File file = new File("E:/studentfiles/" + xmlFileName + ".xml");
			JAXBContext jaxb = JAXBContext.newInstance(Address.class);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.marshal(address, file);
			System.out.println("xml file created");
		} catch (JAXBException e) 
		{
			e.printStackTrace();
		}
	}

	//Exports the student to an xml file.
	public Address persistXmlFiletoStudent(File xmlFileName) 
	{
		try 
		{
			JAXBContext jaxb = JAXBContext.newInstance(Address.class);
			Unmarshaller unmarshaller = jaxb.createUnmarshaller();
			return (Address) unmarshaller.unmarshal(xmlFileName);
		} catch (JAXBException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	public void createStudent(Student student) 
	{
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(student);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void deletePerson(Integer studentId){
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Person p = em.find(Person.class, studentId);
		em.remove(p);
		
		em.getTransaction().commit();
		em.close();
	}
	
		public static void main(String[] args) 
	{
		StudentDAO dao = new StudentDAO();
		//		List<Site> sites = dao.findAllSites();
		/*Student student = dao.getStudentDetailsForStudentLandingPage(1);
		dao.createStudent(student);

		System.out.println(student.getStudentId());
		System.out.println(student.getPerson().getPersonName());
		System.out.println(student.getDegree().getCollege().getCollegeName());*/

		//dao.exportStudentDatabaseToXmlFile(student, "student.xml");

		/*File file = new File("student.xml");

		student = dao.persistXmlFiletoStudent(file);*/
		
//		Address a = new Address();
//		a.setCity(student.getPerson().getAddress().getCity());
//		a.setCountry(student.getPerson().getAddress().getCountry());
//		a.setState(student.getPerson().getAddress().getState());
//		a.setStreet(student.getPerson().getAddress().getStreet());
//		a.setZipCode(student.getPerson().getAddress().getZipCode());
//
//		AddressDAO aDao = new AddressDAO();
//		aDao.insertAddress(a);
//
//		Person p = new Person();
//		p.setAddress(a);
//		p.setEmail(student.getPerson().getEmail());
//		p.setPassword(student.getPerson().getPassword());
//		p.setRoleName(student.getPerson().getRoleName());
//
//		p.setPersonName(student.getPerson().getPersonName());
//		//p.setRole(r);
//		p.setUserName(student.getPerson().getUserName());
//
//		PersonDAO pDao = new PersonDAO();
//		pDao.insertPerson(p);
//		
//		Degree d = new Degree();
//		d.setCollegeName(student.getDegree().getCollegeName());
//		d.setDegreeName(student.getDegree().getDegreeName());
//		d.setDuration(student.getDegree().getDuration());
//		d.setTuition(student.getDegree().getTuition());
//		DegreeDAO dDao = new DegreeDAO();
//		dDao.createStudent(d);
		
		
		//System.out.println(student.getDegree().getUniversity().getUniversityName());

		//		dao.convertXmlFileToOutputFile("sites.xml", "sites2equipment.html", "sites2equipment.xsl");
		
		/*List<Student> studentswantingfund = dao.getStudentFromUni("wentworth");
		
		for(Student s : studentswantingfund){
			System.out.println(s.getStudentId());
		}*/
		
		//dao.deletePerson(1);
		
		String xmlFileName = "kavya";
		Address a = new Address();
		a.setAddressId(1);
		a.setCity("dkfhkd");
		a.setCountry("usa");
		a.setState("ma");
		a.setStreet("hemenway");
		a.setZipCode(02110);
		
		dao.exportStudentDatabaseToXmlFile(a, xmlFileName);
		

	}
}


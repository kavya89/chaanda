package edu.neu.cs5200.chaanda.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Degree {
	
	@Id
	private Integer degreeId;
	private String degreeName;
	private Integer duration;
	private Float tuition;

	@ManyToOne
	private University university;
	
	@OneToMany
	private List<Student> students;

	public Integer getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(Integer degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Float getTuition() {
		return tuition;
	}

	public void setTuition(Float tuition) {
		this.tuition = tuition;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Degree(Integer degreeId, String degreeName, Integer duration,
			Float tuition, University university, List<Student> students) {
		super();
		this.degreeId = degreeId;
		this.degreeName = degreeName;
		this.duration = duration;
		this.tuition = tuition;
		this.university = university;
		this.students = students;
	}

	public Degree() {
		super();
	}
	
	
	
}

package org.mac.raci.db.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PERSONS", uniqueConstraints = @UniqueConstraint(columnNames = { }) )
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String city;

	private String fullname;

	private String email;
	
	@ManyToMany
	private final List<CompetenceLevel> competenceLevels = new ArrayList<CompetenceLevel>();

	@OneToMany(mappedBy="assignee")
	private final List<ProjectAllocation> projectAllocations = new ArrayList<ProjectAllocation>();
	
	@Column(name = "CITY", nullable = false, length = 128)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "FULLNAME", nullable = false, length = 128)
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "EMAILADDRESS", nullable = false, length = 128)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Collection<CompetenceLevel> getCompetenceLevels() {
		return competenceLevels;
	}
	
	public Collection<ProjectAllocation> getProjectAllocationss() {
		return projectAllocations;
	}
	
	
	public void setId(Long id) {
	    this.id = id;
	}

}

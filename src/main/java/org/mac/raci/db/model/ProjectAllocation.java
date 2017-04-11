package org.mac.raci.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPETENCE_RELS")
public class ProjectAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Person assignee;
	private Competency competency;
	private Week week;
	
	@ManyToOne
	public Person getAssignee() {
		return assignee;
	}
	public void setAssignee(Person assignee) {
		this.assignee = assignee;
	}
	
	@ManyToOne
	public Competency getCompetency() {
		return competency;
	}
	
	public void setCompetency(Competency competency) {
		this.competency = competency;
	}
	
	@ManyToOne
	public Week getWeek() {
		return week;
	}
	
	public void setWeek(Week week) {
		this.week = week;
	}


}

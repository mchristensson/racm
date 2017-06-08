package org.mac.raci.db.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "COMPETENCIES", uniqueConstraints = @UniqueConstraint(columnNames = { "LABEL" }) )
public class Competency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String label;
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="competency")
	private final Collection<CompetenceLevel> assignees = new ArrayList<CompetenceLevel>();

	@Column(name = "LABEL", nullable = false, length = 128)
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Collection<CompetenceLevel> getAssignees() {
		return assignees;
	}
}

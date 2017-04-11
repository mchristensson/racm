package org.mac.raci.db.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "FUNCTIONAL_AREAS", uniqueConstraints = @UniqueConstraint(columnNames = { "LABEL" }) )
public class FunctionalArea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String label;

	private Collection<Competency> competencies = new ArrayList<>();

	@Column(name = "LABEL", nullable = false, length = 128)
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@OneToMany
	public Collection<Competency> getCompetencies() {
		return this.competencies;
	}

	public void setCompetencies(Collection<Competency> competencies) {
		this.competencies = competencies;
	}

}

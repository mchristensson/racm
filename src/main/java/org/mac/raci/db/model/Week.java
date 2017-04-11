package org.mac.raci.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "WEEKS", uniqueConstraints = @UniqueConstraint(columnNames = { "YEAR", "WEEK" }) )
public class Week {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String year;

	private String week;

	public void setYear(String year) {
		this.year = year;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Column(name = "YEAR", nullable = false, length = 4)
	public String getYear() {
		return year;
	}

	@Column(name = "WEEK", nullable = false, length = 2)
	public String getWeek() {
		return week;
	}
}

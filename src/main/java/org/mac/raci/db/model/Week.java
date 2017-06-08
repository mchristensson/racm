package org.mac.raci.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "WEEKS", uniqueConstraints = @UniqueConstraint(columnNames = { "weekofyear", "weeknumber" }) )
public class Week {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "weekofyear",insertable=true, length = 4)
	private String year;

	@Column(name = "weeknumber", length = 2)
	private String week;

	public void setYear(String year) {
		this.year = year;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getYear() {
		return year;
	}

	public String getWeek() {
		return week;
	}
}

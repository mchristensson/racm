package org.mac.raci;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;
import org.mac.raci.db.model.Week;

public class DerbyConnectionTest {

	private static final String PERSISTENCE_UNIT_NAME = "roles";

	@Test
	public void testConnection() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// read the existing entries and write to console
		Query q = em.createQuery("select r from ROLES r");
		List<Week> roles = q.getResultList();
		for (Week todo : roles) {
			System.out.println(todo);
		}
		System.out.println("Size: " + roles.size());

		// create new todo
		em.getTransaction().begin();
		Week week = new Week();
		week.setWeek("1");
		week.setYear("2007");
		em.persist(week);
		em.getTransaction().commit();

		em.close();
	}
}

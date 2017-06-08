package org.mac.raci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Test;
import org.mac.raci.db.model.Week;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DerbyConnectionTest {

	private static final String PERSISTENCE_UNIT_NAME = "roles";
	private static final Logger logger = LoggerFactory.getLogger(DerbyConnectionTest.class);

	@Test
	public void testConnection() {
		EntityManager em = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em = factory.createEntityManager();

			//FrameworkUtils.listTables(em);

			//FrameworkUtils.getDataInSchema(em, "APP");

			// create new todo
			em.getTransaction().begin();
			Week week = new Week();
			week.setWeek("1");
			week.setYear("2007");
			em.persist(week);
			em.getTransaction().commit();

		} catch (Exception e) {
			Throwable cause = e.getCause();
			if (cause != null) {
				logger.error(cause.getMessage());
				Assert.fail(cause.getMessage());
			} else {
				logger.error(e.getMessage());
				Assert.fail(e.getMessage());
			}

		} finally {
			if (em != null)
				em.close();

		}
	}

	public static class FrameworkUtils {

		/**
		 * read the existing entries and write to console
		 * 
		 * @param em
		 */
		public static void listRoles(EntityManager em) {
			Query q = em.createQuery("select r from ROLES r");

			List<Week> roles = q.getResultList();
			for (Week todo : roles) {
				System.out.println(todo);
			}
			System.out.println("Size: " + roles.size());
		}

		public static void listTables(EntityManager em) {
			List<String> tables = getTables(em);
			for (Iterator<String> iterator = tables.iterator(); iterator.hasNext();) {
				System.out.println(iterator.next());
			}
		}

		public static void listSchemas(EntityManager em) {
			List<String> schemas = getSchemas(em);
			for (Iterator<String> iterator = schemas.iterator(); iterator.hasNext();) {
				System.out.println(iterator.next());
			}
		}

		public static void getDataInSchema(EntityManager em, String schema) {
			try {
			Query q = em.createNativeQuery("SELECT p FROM PERSONS p");
			List<String> tables = new ArrayList<>();
			@SuppressWarnings("unchecked")
			List<Object[]> r = q.getResultList();
			System.out.println("Size: " + r.size());
			for (Iterator<Object[]> iterator = r.iterator(); iterator.hasNext();) {
				tables.add((String) iterator.next()[1]);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		private static List<String> getTables(EntityManager em) {
			Query q = em.createNativeQuery("SELECT * FROM sys.systables");
			List<String> tables = new ArrayList<>();
			@SuppressWarnings("unchecked")
			List<Object[]> r = q.getResultList();
			System.out.println("Size: " + r.size());
			for (Iterator<Object[]> iterator = r.iterator(); iterator.hasNext();) {
				tables.add((String) iterator.next()[1]);
			}
			return tables;
		}
		
		private static List<String> getSchemas(EntityManager em) {
			Query q = em.createNativeQuery("SELECT * FROM sys.SYSSCHEMAS");
			List<String> schemas = new ArrayList<>();
			@SuppressWarnings("unchecked")
			List<Object[]> r = q.getResultList();
			System.out.println("Size: " + r.size());
			for (Iterator<Object[]> iterator = r.iterator(); iterator.hasNext();) {
				schemas.add((String) iterator.next()[1]);
			}
			return schemas;
		}
	}

}

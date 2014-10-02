package edu.fae.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static void createSessionFactory() {
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			createSessionFactory();
		}
		return sessionFactory;
	}
	
	
}

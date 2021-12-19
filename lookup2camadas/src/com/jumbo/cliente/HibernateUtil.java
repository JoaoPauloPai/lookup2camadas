package com.jumbo.cliente;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static SessionFactory sessions = new AnnotationConfiguration().configure().buildSessionFactory();
	public static SessionFactory getSessionFactory() {
		return sessions;
	}
}

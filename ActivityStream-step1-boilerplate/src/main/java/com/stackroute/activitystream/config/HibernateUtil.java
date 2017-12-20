package com.stackroute.activitystream.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	/*
	 * build the sessionFactory object based on the parameters from
	 * hibernate.cfg.xml file. Also, handle exception if the session factory
	 * object can't be created
	 */

	static SessionFactory sessionFactory = getSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {

				// configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"))
				Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
				StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
				serviceRegistryBuilder.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			}

			return sessionFactory;
		} catch (Throwable ex) {
			System.out.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}

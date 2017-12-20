package com.stackroute.activitystream.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.config.HibernateUtil;
import com.stackroute.activitystream.model.Message;

/*
 * This class contains the code for database interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */



public class MessageRepository {

	// declare SessionFactroy and Session object.
	SessionFactory sessionFactory = null;
	Session session = null;

	public MessageRepository() {

		// create a HibernateSessionFactory from HibernateUtil
		sessionFactory = HibernateUtil.getSessionFactory();

	}

	/*
	 * This method is used to save messages in database. Perform exception
	 * handling and close the session in the finally block
	 */

	public boolean sendMessage(Message message) {

		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(message);
			tx.commit();
			session.flush();
			return true;

		} catch (Exception e) {
			System.out.println("exception occured while saving message to the Database" + e);
			return false;
		} finally {
			if (session != null) {
				session.close();

			}
		}

	}

	/*
	 * This method is used to retrieve all messages from the database. Perform
	 * exception handling and close the session in the finally block
	 */

	@SuppressWarnings("deprecation")
	public List<Message> getAllMessages() {

		List<Message> messages = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Message";
			Query query = session.createQuery(hql);
			messages = (List<Message>) query.list();
			tx.commit();
			session.flush();

		} catch (Exception e) {
			System.out.println("exceptionn occured while saving message to the Database" + e);
			messages = null;

		} finally {
			if (session != null) {
				session.close();

			}
			return messages;
		}

	}
}

package com.stackroute.activitystream.daoimpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

/*
 * This class is implementing the MessageDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */

@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * retrieve all existing messages sorted by posted Date in descending
	 * order(showing latest message first)
	 */
	@SuppressWarnings({ "null", "unchecked" })
	@Override
	public List<Message> getMessages() {

		List<Message> messages = new ArrayList<>();
		List<Message> reverseMessages = new ArrayList<>();
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "from Message";
			Query query = session.createQuery(hql);
			messages = (List<Message>) query.list();
			
			
			for (int i = messages.size()-1; i >= 0; i--) {

				reverseMessages.add(messages.get(i));

			}
			
	
			

		//	System.out.println(reverseMessages.toString());
			System.out.println(messages.toString());
			tx.commit();
			session.flush();
			session.close();
			return reverseMessages;

		} catch (Exception e) {
			System.out.println("exceptionn occured while retrieving message to the Database" + e);
			messages = null;

		}
		return messages;
	}

	/*
	 * Save the message in the database in message table
	 */
	@Override
	public boolean sendMessage(Message message) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(message);
			tx.commit();
			session.flush();
			session.close();
			return true;

		} catch (Exception e) {
			System.out.println("exception occured while saving message to the Database" + e);
			return false;
		}

	}

	/*
	 * Remove the message from the database in message table
	 */

	@Override
	public boolean removeMessage(Message message) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
		/*	Message retrieved_Message = session.get(Message.class, message.getMessageId());
			session.delete(retrieved_Message);
		*/	tx.commit();
			session.flush();
			session.close();
			return true;

		} catch (Exception e) {
			System.out.println("exception occured while saving message to the Database" + e);
			return false;
		}

	}

}

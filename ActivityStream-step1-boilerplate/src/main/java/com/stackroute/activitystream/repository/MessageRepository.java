package com.stackroute.activitystream.repository;

import java.util.List;

import com.stackroute.activitystream.model.Message;


/*
 * This class contains the code for database interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */
public class MessageRepository {
	
	/*
	 * declare SessionFactory and Session objects
	 * /
	
	public MessageRepository() {
		/*
		 * create a hibernate SessionFactory from HibernateUtil
		 */
		
	
	
	/*
	 * This method is used to save messages in database. Perform exception handling and
	 * close the session in the finally block
	 */ 
	public boolean sendMessage(Message message) {
		
		return false;

		
	}
	
	/*
	 * This method is used to retrieve all messages in database. Perform exception handling and
	 * close the session in the finally block
	 */
	public List<Message> getAllMessages(){
		
		return null;
	}
}

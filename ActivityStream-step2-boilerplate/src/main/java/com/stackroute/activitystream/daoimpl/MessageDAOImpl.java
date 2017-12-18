package com.stackroute.activitystream.daoimpl;

import java.util.List;

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


public class MessageDAOImpl implements MessageDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory. 
	 */
	

	
	

	/*
	 * retrieve all existing messages sorted by posted Date in descending order(showing latest
	 * message first)
	 */
	@Override
	public List<Message> getMessages() {
		// TODO Auto-generated method stub
		return null;
	}


	/*
	 * Save the message in the database in message table 
	 */
	@Override
	public boolean sendMessage(Message message) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 * Remove the message from the database in message table 
	 */

	@Override
	public boolean removeMessage(Message message) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

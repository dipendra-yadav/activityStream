package com.stackroute.activitystream.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.dao.UserDAO;
import com.stackroute.activitystream.model.UserCircle;

/*
* This class is implementing the UserCircleDAO interface. This class has to be annotated with 
* @Repository annotation.
* @Repository - is an annotation that marks the specific class as a Data Access Object, 
* thus clarifying it's role.
* @Transactional - The transactional annotation itself defines the scope of a single database 
* 					transaction. The database transaction happens inside the scope of a persistence 
* 					context.  
* */
@Repository("userCircleDAO")
@Transactional
public class UserCircleDAOImpl implements UserCircleDAO{
	
	/*
	 * Autowiring should be implemented for the SessionFactory. 
	 */
		
	
	/*
	 * Add a user to a circle 
	 */
	public boolean addUser(String username, String circleName) {

		// TODO Auto-generated method stub		
		return false;
	}

	/*
	 * Remove a user from a circle 
	 */
	public boolean removeUser(String username, String circleName) {
		// TODO Auto-generated method stub
		return true;
	}
	
	/*
	 * Retrieve unique UserCircle object which contains a specific username 
	 * and circleName 
	 */
	public UserCircle get(String username, String circleName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*
	 * Retrieve all subscribed circles by a user 
	 */
	@SuppressWarnings("unchecked")
	public List<String> getMyCircles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}

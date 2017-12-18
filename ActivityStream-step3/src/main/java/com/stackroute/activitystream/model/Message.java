package com.stackroute.activitystream.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 * The class "Message" will be acting as the data model for the message Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */

public class Message {

	/*
	 * This class should have eight fields
	 * (messageId,senderName,receiverId,circleName,postedDate,streamType,message,tag). Out of these four fields, the
	 * field messageId should be auto-generated. This class should also contain
	 * the getters and setters for the fields. The value of postedDate should
	 * not be accepted from the user but should be always initialized with the
	 * system date
	 */
	
	public Message(String string, Object object, Object object2, Object object3, String string2, String string3,
			Object object4) {
		// TODO Auto-generated constructor stub
	}

	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setStreamType(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setSenderName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setTag(String string) {
		// TODO Auto-generated method stub
		
	}

}

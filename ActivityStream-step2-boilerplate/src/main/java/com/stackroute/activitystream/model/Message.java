package com.stackroute.activitystream.model;

/*
 * The class "Message" will be acting as the data model for the message Table in the database. Please
 * note that this class is annotated with @Entity annotation. Hibernate will scan all package for 
 * any Java objects annotated with the @Entity annotation. If it finds any, then it will begin the 
 * process of looking through that particular Java object to recreate it as a table in your database.
 */

public class Message {

	public void setSenderName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setPostedDate() {
		// TODO Auto-generated method stub
		
	}

	public Object getSenderName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * This class should have four fields
	 * (messageId,senderName,postedDate,message). Out of these four fields, the
	 * field messageId should be auto-generated. This class should also contain
	 * the getters and setters for the fields. The value of postedDate should
	 * not be accepted from the user but should be always initialized with the
	 * system date
	 */
	
	

}

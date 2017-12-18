package com.stackroute.activitystream.test;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stackroute.activitystream.config.HibernateUtil;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.repository.MessageRepository;

public class MessageRepositoryTest {

	Session session=null;
	MessageRepository messageRepository;
	
	
	@Before
	public void setup() {
		
		messageRepository=new MessageRepository();
		
	}
	
	@After
	public void teardown() {
		
	}
	
	@Test
	public void testGetListOfMessages() {
		assertNotNull("Retrieval of messages failed.",messageRepository.getAllMessages());
	}
	
	@Test
	public void testSendMessages() {
		session=HibernateUtil.getSessionFactory().openSession();
		Message message=new Message();
		message.setSenderName("John");
		message.setMessage("Sample message");
		message.setPostedDate();
		
		messageRepository.sendMessage(message);
		
		List<Message> messages=messageRepository.getAllMessages();
		boolean found=false;
		for(Message msg:messages)
		{
			if(msg.getSenderName().equals("John") && msg.getMessage().equals("Sample message")) {
				found=true;
			}
		}
		
		assertEquals("Sending of messages failed",true,found);
		
		session.beginTransaction();
		session.delete(message);
		session.getTransaction().commit();
			
	}
	

}

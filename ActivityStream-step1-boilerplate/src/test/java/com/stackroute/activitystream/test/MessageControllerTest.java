package com.stackroute.activitystream.test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.stackroute.activitystream.config.ApplicationContextConfig;
import com.stackroute.activitystream.controller.MessageController;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.repository.MessageRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContextConfig.class})
@WebAppConfiguration
public class MessageControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private MessageRepository messageRepository;
	
	@InjectMocks
	private MessageController messageController=new MessageController();
		
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
	
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(messageController)
				.build();	
	}
	
	@Test
    public void testGetAllMessages() throws Exception {
		
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("index"))
                ;
                
    }
	
	@Test
    public void testSendMessages() throws Exception {

        mockMvc.perform(post("/sendMessage")
        			.param("sender", "Tom")
        			.param("message", "How are you?"))
                //.andExpect(status().isOk())
                //.andExpect(view().name("index"))
                .andExpect(redirectedUrl("/"))
                ;
 
    }
	
	@Test
    public void testSendMessagesEmptySenderFailure() throws Exception {

        mockMvc.perform(post("/sendMessage")
        			.param("sender", "")
        			.param("message", "How are you?"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                ;
 
    }
	
	@Test
    public void testSendMessagesEmptyMessageFailure() throws Exception {

        mockMvc.perform(post("/sendMessage")
        			.param("sender", "Tom")
        			.param("message", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                ;
 
    }
	
	@Test
    public void testSendMessagesEmptySenderAndMessageFailure() throws Exception {

        mockMvc.perform(post("/sendMessage")
        			.param("sender", "")
        			.param("message", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                ;
 
    }
	
}

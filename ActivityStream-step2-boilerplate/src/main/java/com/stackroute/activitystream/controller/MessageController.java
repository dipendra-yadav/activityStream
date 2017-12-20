package com.stackroute.activitystream.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.activitystream.dao.MessageDAO;
import com.stackroute.activitystream.model.Message;

@Controller
public class MessageController {

	@Autowired
	MessageDAO messageDao;

	@Autowired
	Message message;

	/*
	 * Define a handler method to read the existing messages from the database
	 * and add it to the ModelMap which is an implementation of Map for use when
	 * building model data for use with views. it should map to the default URL
	 * i.e. "/"
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllMessages(ModelMap map) {
		map.addAttribute("messageList", messageDao.getMessages());
		map.addAttribute("message", new Message());
		return "index";
	}

	/*
	 * Define a handler method which will read the senderName and message from
	 * request parameters and save the message in message table in database.
	 * Please note that the timestamp should always be auto populated with
	 * system time and should not be accepted from the user. Also, after saving
	 * the message, it should show the same along with existing messages. Hence,
	 * reading messages has to be done here again and the retrieved messages
	 * object should be sent back to the view using ModelMap This handler method
	 * should map to the URL "/sendMessage".
	 */

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public String sendMessage(@RequestParam(value = "senderName") String senderName,
			@RequestParam(value = "message") String mess, ModelMap map) {

		message.setMessage(mess);
		message.setSenderName(senderName);
		messageDao.sendMessage(message);
		return "redirect:/";

	}

}

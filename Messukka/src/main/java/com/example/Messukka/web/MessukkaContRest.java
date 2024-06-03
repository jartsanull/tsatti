package com.example.Messukka.web;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Messukka.domain.Message;
import com.example.Messukka.domain.MessageRepo;
import com.example.Messukka.domain.User;
import com.example.Messukka.domain.UserRepository;


@CrossOrigin
@Controller
public class MessukkaContRest {
	
	@Autowired
	private MessageRepo repo; 
	
	

    @RequestMapping(value="/messages", method = RequestMethod.GET)
    public @ResponseBody List<Message> messageRest() {	
        return (List<Message>) repo.findAll();
    }    

    @RequestMapping(value="/messages/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Message> findMeseRest(@PathVariable("id") Long messageId) {	
    	return repo.findById(messageId);
    }      
    
    @RequestMapping(value="/messages", method = RequestMethod.POST)
    public @ResponseBody Message saveMeseRest(@RequestBody Message message) {	
    	return repo.save(message);
    }

}

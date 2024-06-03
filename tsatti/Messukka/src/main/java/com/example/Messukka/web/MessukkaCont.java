package com.example.Messukka.web;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Messukka.domain.Message;
import com.example.Messukka.domain.MessageRepo;
import com.example.Messukka.domain.UserRepository;
import com.example.Messukka.domain.User;


import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessukkaCont {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
    private MessageRepo repo;

    public MessukkaCont(MessageRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/chat")
    public String chat(Model model) {
        model.addAttribute("messages", repo.findAll());
        return "chat";
    }
    

    @PostMapping("/send")
    public String sendMessage(@RequestParam("content") String content, Principal principal) {
    //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //String sender = authentication.getName();
    	System.out.print("heippa");
      String username = principal.getName(); //get logged in username

//      User user = userRepo.findByUsername(username);
      
        Message message = new Message(username, content);
        repo.save(message); 

        return "redirect:/chat";
    }
}

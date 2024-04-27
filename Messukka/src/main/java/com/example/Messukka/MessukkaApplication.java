package com.example.Messukka;

import java.time.LocalDateTime;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Messukka.domain.Message;
import com.example.Messukka.domain.User;
import com.example.Messukka.domain.UserRepository;
import com.example.Messukka.domain.MessageRepo;

@SpringBootApplication
public class MessukkaApplication {
	

	
	private static final Logger log = LoggerFactory.getLogger(MessukkaApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MessukkaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Messukka(MessageRepo repo,  UserRepository userRepo) {
		return (args) -> {
			

			repo.save(new Message("Kimmo", "hei"));
			repo.save(new Message("Toni", "moi sinnekki"));

		    log.info("Initial messages inserted");
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepo.save(user1);
            userRepo.save(user2);
            
		

						
			


		};
	}

}

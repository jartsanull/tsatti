package com.example.Messukka;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Messukka.domain.Message;
import com.example.Messukka.domain.MessageRepo;
import com.example.Messukka.domain.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional; 


@SpringBootTest
public class MessukkaRepoTest {
	
	@PersistenceContext
	 private EntityManager entityManager;

	
	@Autowired
	private MessageRepo repo;

	@Test
	public void findBySenderShouldReturnMessage() {
		List<Message> message = repo.findBySender("Toni");
		
		
		assertThat(message).hasSize(1);
		assertThat(message.get(0).getContent()).isEqualTo("moi sinnekki");
	}
	
	@Test
	@Transactional
	public void createNewMessage() {
		

		
		Message mese = new Message("Anna", "antaaks joku mulle omenan kiitos");
		repo.save(mese);
		assertThat(mese.getId()).isNotNull();
	
	}
	
	

}

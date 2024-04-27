package com.example.Messukka.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.Messukka.domain.Message;

public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findBySender(String sender);
}

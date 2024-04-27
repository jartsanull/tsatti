package com.example.Messukka.domain;


import org.springframework.data.repository.CrudRepository;


import com.example.Messukka.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}

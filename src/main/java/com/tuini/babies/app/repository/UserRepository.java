package com.tuini.babies.app.repository;

import com.tuini.babies.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Optional<User> findById(Long id);
//	UserClient findById(Long id);
	Boolean existsByUsername(String username);
}

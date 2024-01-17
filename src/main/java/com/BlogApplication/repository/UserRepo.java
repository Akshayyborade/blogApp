package com.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BlogApplication.model.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
 List<User> findByEmail(String email);
}

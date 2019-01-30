package com.cts.skynews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.skynews.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByEmail(String email);
}

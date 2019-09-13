package com.example.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.batch.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}

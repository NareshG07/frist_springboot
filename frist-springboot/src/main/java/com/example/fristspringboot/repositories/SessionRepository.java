package com.example.fristspringboot.repositories;

import com.example.fristspringboot.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}

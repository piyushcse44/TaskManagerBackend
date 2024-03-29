package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT s FROM Users s WHERE s.email = ?1")
    Optional<Users> findByEmail(String email);

}

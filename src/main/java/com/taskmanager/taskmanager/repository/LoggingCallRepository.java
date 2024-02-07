package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.model.LoggingCall;
import com.taskmanager.taskmanager.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface LoggingCallRepository extends JpaRepository<LoggingCall,Long> {

}

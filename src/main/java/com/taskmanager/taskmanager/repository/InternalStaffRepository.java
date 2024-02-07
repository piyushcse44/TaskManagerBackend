package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.model.InternalStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InternalStaffRepository extends JpaRepository<InternalStaff,Long> {
    @Query("SELECT s FROM InternalStaff s WHERE s.email = ?1")
    Optional<InternalStaff> findByEmail(String email);

}

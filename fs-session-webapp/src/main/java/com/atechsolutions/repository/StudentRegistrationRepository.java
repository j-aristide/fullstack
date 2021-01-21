package com.atechsolutions.repository;

import com.atechsolutions.model.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {
}

package com.katerynamykh.task.repository;

import com.katerynamykh.task.model.Company;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
	Optional<Company> findByRegistrationNumberIgnoreCase(String registrationNumber);
}

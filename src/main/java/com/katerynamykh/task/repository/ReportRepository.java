package com.katerynamykh.task.repository;

import com.katerynamykh.task.model.Report;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, UUID> {
    Page<Report> findAllByCompanyId(UUID companyId, Pageable pageable);
}

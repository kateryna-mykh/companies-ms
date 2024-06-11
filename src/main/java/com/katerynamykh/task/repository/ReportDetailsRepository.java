package com.katerynamykh.task.repository;

import com.katerynamykh.task.model.ReportDetails;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportDetailsRepository extends MongoRepository<ReportDetails, UUID> {
    @Query("{report_id:'?0'}")
    Optional<ReportDetails> findDetailsByReportId(UUID reportId);
}

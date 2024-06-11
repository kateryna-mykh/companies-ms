package com.katerynamykh.task.model;

import jakarta.persistence.Column;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("report_details")
public class ReportDetails {
    @Id
    @Column(name = "report_id")
    private UUID reportId;
    @Column(name = "financial_data")
    private String financialData;
    private String comments;
}

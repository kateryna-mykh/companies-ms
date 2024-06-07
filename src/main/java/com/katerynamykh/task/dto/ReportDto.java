package com.katerynamykh.task.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record ReportDto(
		UUID id, 
		UUID companyId, 
		Instant reportDate, 
		BigDecimal totalRevenue, 
		BigDecimal netProfit) {
}

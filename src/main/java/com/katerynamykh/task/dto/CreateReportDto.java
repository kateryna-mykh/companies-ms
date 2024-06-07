package com.katerynamykh.task.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

public record CreateReportDto(
		@NotNull(message = "comapny id is requierd")
		UUID companyId,
		@Min(0)
		@NotNull(message = "total revenue is requiered")
		BigDecimal totalRevenue, 
		BigDecimal netProfit) {

}

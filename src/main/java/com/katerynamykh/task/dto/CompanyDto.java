package com.katerynamykh.task.dto;

import java.time.Instant;
import java.util.UUID;

public record CompanyDto(
	UUID id, 
	String name,
	String registrationNumber, 
	Instant createdAt) {
}

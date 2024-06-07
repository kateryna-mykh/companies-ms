package com.katerynamykh.task.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCompanyDto(
		@NotBlank(message = "company name shouldn't be blank")
		String name,
		@NotBlank(message = "registration number shouldn't be blank")
		String registrationNumber) {

}

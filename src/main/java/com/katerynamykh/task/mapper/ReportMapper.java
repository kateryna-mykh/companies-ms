package com.katerynamykh.task.mapper;

import com.katerynamykh.task.config.MapperConfig;
import com.katerynamykh.task.dto.CreateReportDto;
import com.katerynamykh.task.dto.ReportDto;
import com.katerynamykh.task.model.Company;
import com.katerynamykh.task.model.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface ReportMapper {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "reportDate", ignore = true)
	Report toModel(CreateReportDto reportDto, Company company);

	@Mapping(target = "companyId", source = "company.id")
	ReportDto toDto(Report report);
}

package com.katerynamykh.task.mapper;

import com.katerynamykh.task.config.MapperConfig;
import com.katerynamykh.task.dto.CompanyDto;
import com.katerynamykh.task.dto.CreateCompanyDto;
import com.katerynamykh.task.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface CompanyMapper {
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "reports", ignore = true)
	Company toModel(CreateCompanyDto chainDto);

	CompanyDto toDto(Company chain);
}

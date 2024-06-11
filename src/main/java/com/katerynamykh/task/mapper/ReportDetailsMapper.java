package com.katerynamykh.task.mapper;

import com.katerynamykh.task.config.MapperConfig;
import com.katerynamykh.task.dto.ReportDetailsDto;
import com.katerynamykh.task.model.ReportDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface ReportDetailsMapper {
    @Mapping(target = "reportId", ignore = true)
    ReportDetails toModel(ReportDetailsDto detailsDto);

    ReportDetailsDto toDto(ReportDetails details);
}

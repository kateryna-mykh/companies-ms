package com.katerynamykh.task.service;

import com.katerynamykh.task.dto.CreateReportDto;
import com.katerynamykh.task.dto.ReportDto;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Pageable;

public interface ReportService {
	ReportDto save(CreateReportDto reportDto);

	ReportDto update(UUID id, CreateReportDto reportDto);

	List<ReportDto> findAll(Pageable pageable);

	ReportDto findById(UUID id);

	void delete(UUID id);
	
	List<ReportDto> findAllByCompanyId(UUID companyId, Pageable pageable);
}

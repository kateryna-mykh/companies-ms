package com.katerynamykh.task.service.impl;

import com.katerynamykh.task.dto.CreateReportDto;
import com.katerynamykh.task.dto.ReportDto;
import com.katerynamykh.task.mapper.ReportMapper;
import com.katerynamykh.task.model.Company;
import com.katerynamykh.task.model.Report;
import com.katerynamykh.task.repository.CompanyRepository;
import com.katerynamykh.task.repository.ReportRepository;
import com.katerynamykh.task.service.ReportService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {
	private final ReportRepository reportRepository;
	private final CompanyRepository companyRepository;
	private final ReportMapper mapper;

	@Transactional
	@Override
	public ReportDto save(CreateReportDto reportDto) {
		Company companyById = companyRepository.findById(reportDto.companyId())
				.orElseThrow(() -> new RuntimeException("Can't find company by id: " + reportDto.companyId()));
		return mapper.toDto(reportRepository.save(mapper.toModel(reportDto, companyById)));
	}

	@Transactional
	@Override
	public ReportDto update(UUID id, CreateReportDto reportDto) {
		Company companyById = companyRepository.findById(reportDto.companyId())
				.orElseThrow(() -> new RuntimeException("Can't find company by id: " + reportDto.companyId()));
		Report report = mapper.toModel(reportDto, companyById);
		report.setId(id);
		return mapper.toDto(reportRepository.save(report));
	}

	@Override
	public List<ReportDto> findAll(Pageable pageable) {
		return reportRepository.findAll(pageable).stream().map(mapper::toDto).toList();
	}

	@Override
	public ReportDto findById(UUID id) {
		Report reportById = reportRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Can't find report by id: " + id));
		return mapper.toDto(reportById);
	}

	@Override
	public void delete(UUID id) {
		reportRepository.deleteById(id);
	}

	@Override
	public List<ReportDto> findAllByCompanyId(UUID companyId, Pageable pageable) {
		return reportRepository.findAllByCompanyId(companyId, pageable).stream()
				.map(mapper::toDto)
				.toList();
	}
}

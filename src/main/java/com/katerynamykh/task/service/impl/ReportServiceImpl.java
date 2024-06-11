package com.katerynamykh.task.service.impl;

import com.katerynamykh.task.dto.CreateReportDto;
import com.katerynamykh.task.dto.ReportDetailsDto;
import com.katerynamykh.task.dto.ReportDto;
import com.katerynamykh.task.exception.EntityNotFoundException;
import com.katerynamykh.task.mapper.ReportDetailsMapper;
import com.katerynamykh.task.mapper.ReportMapper;
import com.katerynamykh.task.model.Company;
import com.katerynamykh.task.model.Report;
import com.katerynamykh.task.model.ReportDetails;
import com.katerynamykh.task.repository.CompanyRepository;
import com.katerynamykh.task.repository.ReportDetailsRepository;
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
    private final ReportDetailsRepository reportDetailsRepository;
    private final CompanyRepository companyRepository;
    private final ReportMapper reportMapper;
    private final ReportDetailsMapper detailsMapper;

    @Transactional
    @Override
    public ReportDto save(CreateReportDto reportDto) {
	Company companyById = companyRepository.findById(reportDto.companyId())
		.orElseThrow(() -> new EntityNotFoundException("Can't find company by id: " + reportDto.companyId()));

	Report savedReport = reportRepository.save(reportMapper.toModel(reportDto, companyById));
	saveDetails(savedReport.getId(), reportDto.details());
	return reportMapper.toDto(savedReport);
    }

    @Transactional
    @Override
    public ReportDto update(UUID id, CreateReportDto reportDto) {
	Company companyById = companyRepository.findById(reportDto.companyId())
		.orElseThrow(() -> new EntityNotFoundException("Can't find company by id: " + reportDto.companyId()));
	Report report = reportMapper.toModel(reportDto, companyById);
	report.setId(id);
	if (reportDto.details() != null) {
	    saveDetails(id, reportDto.details());
	}

	return reportMapper.toDto(reportRepository.save(report));
    }

    @Override
    public List<ReportDto> findAll(Pageable pageable) {
	return reportRepository.findAll(pageable).stream().map(reportMapper::toDto).toList();
    }

    @Override
    public ReportDto findById(UUID id) {
	Report reportById = reportRepository.findById(id)
		.orElseThrow(() -> new EntityNotFoundException("Can't find report by id: " + id));
	return reportMapper.toDto(reportById);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
	reportRepository.deleteById(id);
	reportDetailsRepository.deleteById(id);
    }

    @Override
    public List<ReportDto> findAllByCompanyId(UUID companyId, Pageable pageable) {
	return reportRepository.findAllByCompanyId(companyId, pageable).stream().map(reportMapper::toDto).toList();
    }

    private ReportDetails saveDetails(UUID reportId, ReportDetailsDto detailsDto) {
	ReportDetails details = detailsMapper.toModel(detailsDto);
	details.setReportId(reportId);
	return reportDetailsRepository.save(details);
    }

    @Override
    public ReportDetailsDto findReportDetails(UUID reportId) {
	ReportDetails detailsById = reportDetailsRepository.findDetailsByReportId(reportId)
		.orElseThrow(() -> new EntityNotFoundException("Can't find report details by id: " + reportId));
	return detailsMapper.toDto(detailsById);
    }
}

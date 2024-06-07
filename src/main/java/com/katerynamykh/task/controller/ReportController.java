package com.katerynamykh.task.controller;

import com.katerynamykh.task.dto.CreateReportDto;
import com.katerynamykh.task.dto.ReportDto;
import com.katerynamykh.task.service.ReportService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reports")
public class ReportController {
	private final ReportService reportService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ReportDto> findAll(Pageable pageable) {
		return reportService.findAll(pageable);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ReportDto create(@RequestBody @Valid CreateReportDto reportDto) {
		return reportService.save(reportDto);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ReportDto updateById(@PathVariable UUID id, @RequestBody @Valid CreateReportDto reportDto) {
		return reportService.update(id, reportDto);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ReportDto findById(@PathVariable UUID id) {
		return reportService.findById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		reportService.delete(id);
	}

	@GetMapping("/by-company/{id}")
	public List<ReportDto> findAllByCompanyId(@PathVariable UUID id, Pageable pageable) {
		return reportService.findAllByCompanyId(id, pageable);
	}
}

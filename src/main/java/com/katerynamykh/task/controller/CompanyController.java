package com.katerynamykh.task.controller;

import com.katerynamykh.task.dto.CompanyDto;
import com.katerynamykh.task.dto.CreateCompanyDto;
import com.katerynamykh.task.service.CompanyService;
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
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompanyDto> findAll(Pageable pageable) {
	return companyService.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyDto create(@RequestBody @Valid CreateCompanyDto companyDto) {
	return companyService.save(companyDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompanyDto updateById(@PathVariable UUID id, @RequestBody @Valid CreateCompanyDto companyDto) {
	return companyService.update(id, companyDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompanyDto findById(@PathVariable UUID id) {
	return companyService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
	companyService.delete(id);
    }
}

package com.katerynamykh.task.service;

import com.katerynamykh.task.dto.CompanyDto;
import com.katerynamykh.task.dto.CreateCompanyDto;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Pageable;

public interface CompanyService {
    CompanyDto save(CreateCompanyDto reportDto);

    CompanyDto update(UUID id, CreateCompanyDto reportDto);

    List<CompanyDto> findAll(Pageable pageable);

    CompanyDto findById(UUID id);

    void delete(UUID id);
}

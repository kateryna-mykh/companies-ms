package com.katerynamykh.task.service.impl;

import com.katerynamykh.task.dto.CompanyDto;
import com.katerynamykh.task.dto.CreateCompanyDto;
import com.katerynamykh.task.mapper.CompanyMapper;
import com.katerynamykh.task.model.Company;
import com.katerynamykh.task.repository.CompanyRepository;
import com.katerynamykh.task.service.CompanyService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final CompanyMapper mapper;

    @Transactional
    @Override
    public CompanyDto save(CreateCompanyDto reportDto) {
	if (repository.findByRegistrationNumberIgnoreCase(reportDto.registrationNumber()).isPresent()) {
	    throw new RuntimeException("Failed to save duplicate company");
	}
	return mapper.toDto(repository.save(mapper.toModel(reportDto)));
    }

    @Transactional
    @Override
    public CompanyDto update(UUID id, CreateCompanyDto reportDto) {
	Optional<Company> foundCompany = repository.findByRegistrationNumberIgnoreCase(reportDto.registrationNumber());
	if (foundCompany.isPresent() && !id.equals(foundCompany.get().getId())) {
	    throw new RuntimeException("Failed to save duplicate company");
	}
	Company company = mapper.toModel(reportDto);
	company.setId(id);
	if (foundCompany.isPresent()) {
	    company.setCreatedAt(foundCompany.get().getCreatedAt());
	}
	return mapper.toDto(repository.save(company));
    }

    @Override
    public List<CompanyDto> findAll(Pageable pageable) {
	return repository.findAll(pageable).stream().map(mapper::toDto).toList();
    }

    @Override
    public CompanyDto findById(UUID id) {
	Company companyById = repository.findById(id)
		.orElseThrow(() -> new RuntimeException("Can't find company by id: " + id));
	return mapper.toDto(companyById);
    }

    @Override
    public void delete(UUID id) {
	repository.deleteById(id);
    }
}

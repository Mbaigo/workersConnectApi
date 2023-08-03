package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.ExperienceRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.ExperienceDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Experience;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.ExperienceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository experienceRepository;
    private ModelMapper modelMapper;

    public ExperienceServiceImpl(ExperienceRepository experienceRepository, ModelMapper modelMapper) {
        this.experienceRepository = experienceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Experience add(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public ExperienceDTO update(Long id, ExperienceDTO experience) {
        Experience e =experienceRepository.findById(id).get();
        e.setTitle(experience.getTitle());
        e.setDescription(experience.getDescription());
        e.setEnterprise(experience.getEnterprise());
        e.setStartDate(experience.getStartDate());
        e.setEndDate(experience.getEndDate());
        ExperienceDTO experienceDTO = modelMapper.map(e, ExperienceDTO.class);
        experienceRepository.save(e);
        return experienceDTO;
    }
    @Override
    public Set<Experience> getAll() {
        return (Set<Experience>) experienceRepository.findAll();
    }
}

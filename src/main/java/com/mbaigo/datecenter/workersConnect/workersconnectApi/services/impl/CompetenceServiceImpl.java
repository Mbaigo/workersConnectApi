package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.CompetenceRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.CompetenceDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Competence;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.CompetenceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompetenceServiceImpl implements CompetenceService {
    private  final CompetenceRepository competenceRepository;
    private ModelMapper modelMapper;
    @Override
    public Competence add(Competence competence) {
        return competenceRepository.save(competence);
    }

    @Override
    public Optional<Competence> update(Long id, CompetenceDTO competence) {
       Optional<Competence> c = competenceRepository.findById(id);
       Competence competence1=c.orElse(new Competence());
       competence1.setTitle(competence.getTitle());
       competence1.setLevel(competence.getLevel());
       return Optional.of(competenceRepository.save(competence1));
    }
    @Override
    public List<Competence> getAll() {
        return competenceRepository.findAll();
    }

    @Override
    public Competence getById(Long id) {
        return competenceRepository.findById(id).get();
    }

}

package com.mbaigo.datecenter.workersConnect.workersconnectApi.resources;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.CompetenceDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Competence;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.CompetenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("api/competences")
public class CompetenceController {
    private final CompetenceService competenceService;
    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }
    @PostMapping
    public Competence create(@RequestBody Competence competence){
        return competenceService.add(competence);
    }
    @PutMapping("{id}")
    public Optional<Competence> update(@PathVariable Long id, @RequestBody CompetenceDTO competence){
        return competenceService.update(id,competence);
    }
    @GetMapping
    public List<Competence> getAll(){
        return competenceService.getAll();
    }
    @GetMapping("{id}")
    public Competence getById(@PathVariable Long id){
        return competenceService.getById(id);
    }
}

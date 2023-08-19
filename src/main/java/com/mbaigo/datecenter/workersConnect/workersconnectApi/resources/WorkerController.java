package com.mbaigo.datecenter.workersConnect.workersconnectApi.resources;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.CompetenceDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.WorkerDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.errors.ErrorResponse;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.exceptions.WorkerException;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Competence;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Worker;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController @RequestMapping("api/workers")
public class WorkerController {
    private  final WorkerService workerService;
    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }
    @GetMapping
    public Collection<WorkerDTO> getAll(){
        return workerService.getAll();
    }
    @PostMapping
    public ResponseEntity<WorkerDTO> add(@RequestBody WorkerDTO workerDTO){
        Collection<Competence> competences = workerDTO.getCompetences();
        return ResponseEntity.ok(workerService.add(workerDTO, competences));
    }
    @PatchMapping("{id}")
    public WorkerDTO update(@PathVariable("id")  Long id, @RequestBody WorkerDTO dto){
        return workerService.update(id, dto);
    }
    @GetMapping("{id}")
    public Worker getById(@PathVariable Long id){
        return workerService.getById(id);
    }

    @GetMapping("/worker-by-email")
    public ResponseEntity<?> getByEmail(@RequestParam("email") String email){
        try{
            WorkerDTO workerDTO =workerService.getByEmail(email);
            return ResponseEntity.ok(workerDTO);
        } catch (WorkerException workerException){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(workerException.getMessage());
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setTimestamp(System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);

        }
    }

    @GetMapping("/worker-by-lastdiplome")
    public ResponseEntity<?> getByLastdiplome(@RequestParam("lastdiplome") String lastdiplome){
        try {
            Collection<WorkerDTO> workerDTOS = workerService.getByLastdiplome(lastdiplome);
            return  ResponseEntity.ok(workerDTOS);
        } catch (WorkerException workerException){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(workerException.getMessage());
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setTimestamp(System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/worker-by-country")
    public ResponseEntity<?>  getByCountry(@RequestParam("country") String country){
        try{
            Collection<WorkerDTO> workerDTOs =workerService.getByCountry(country);
            return ResponseEntity.ok(workerDTOs);
        } catch (WorkerException workerException){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(workerException.getMessage());
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setTimestamp(System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/worker-by-city")
    public ResponseEntity<?>  getByCity(@RequestParam("city") String city){
        try{
            Collection<WorkerDTO> workerDTOs =workerService.getByCity(city);
            return ResponseEntity.ok(workerDTOs);
        } catch (WorkerException workerException){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(workerException.getMessage());
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setTimestamp(System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/worker-by-competence-title")
    public ResponseEntity<?>  getWorkersByCompetenceTitle(@RequestParam("title") String competenceTitle){
        try{
            Collection<WorkerDTO> workerDTOs =workerService.getWorkersByCompetenceTitle(competenceTitle);
            return ResponseEntity.ok(workerDTOs);
        } catch (WorkerException workerException){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage(workerException.getMessage());
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            errorResponse.setTimestamp(System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

}

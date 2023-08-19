package com.mbaigo.datecenter.workersConnect.workersconnectApi.resources;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.OpportunityDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.QualificationDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Qualification;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.State;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.OpportunityService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RestController @RequestMapping("api/opportunities")
public class OpportunityController {
    private final OpportunityService opportunityService;

    public OpportunityController(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }
    @GetMapping("/search-by-qualification-title")
    public Collection<OpportunityDTO> getOpportunityByQualifications_Title(@RequestParam("title") String title){
        return opportunityService.getByQualifications_Title(title);
    }
    @GetMapping("/search-by-provider-email")
    public Collection<OpportunityDTO> getOpportunityByProvider_Email(@RequestParam("email") String email){
        return opportunityService.getByProvider_Email(email);
    }
    @GetMapping("/search-by-provider-title")
    public Collection<OpportunityDTO> getOpportunityByProvider_Title(@RequestParam("providertitle") String providertitle){
        return  opportunityService.getByProvider_Title(providertitle);
    }
    @GetMapping("/search-by-providerId")
    public Collection<OpportunityDTO> getOpportunityByProvider_Id(@RequestParam("providerId") Long providerId){
        return opportunityService.getByProvider_Id(providerId);
    }
    @GetMapping("/search-by-opportinutyTitle")
    public Collection<OpportunityDTO> getOpportunityByTitle(@RequestParam("title") String title){
        return opportunityService.getByTitle(title);
    }
    @GetMapping("/search-by-opportinutyLocation")
    public Collection<OpportunityDTO> getOpportunityByLocation(@RequestParam("location") String location){
        return opportunityService.getByLocation(location);
    }
    @GetMapping("/search-by-opportinutyStatus")
    public Collection<OpportunityDTO> getOpportunityByStatus(@RequestParam("status") State status){
        return opportunityService.getByStatus(status);
    }
    @GetMapping("/search-by-opportinutyByPublicationDate")
    public Collection<OpportunityDTO> getOpportunityByPublicationDate(@RequestParam("date") LocalDateTime date){
        return opportunityService.getByPublicationDate(date);
    }
    @PostMapping
    public Opportunity saveOpportunity(@RequestBody OpportunityDTO opportunityDTO, List<Qualification> qualifications){
        return opportunityService.addOpportunity(opportunityDTO, qualifications);
    }
    @PutMapping("{id}")
    public OpportunityDTO updateOpportunity(@PathVariable Long id,@RequestBody Opportunity opportunity){
        return opportunityService.updateOpportunity(id, opportunity);
    }
    @GetMapping
    public Collection<OpportunityDTO> getAllOpportunity(){
        return opportunityService.getAll();
    }
    @GetMapping("{id}")
    Collection<QualificationDTO>  getQualificationsByOpportunityId(@PathVariable Long id){
        return opportunityService.getQualificationsByOpportunityId(id);
    }


}

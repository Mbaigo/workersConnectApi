package com.mbaigo.datecenter.workersConnect.workersconnectApi.resources;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.ProviderDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Provider;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.ProviderService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController @RequestMapping("api/providers")
public class ProviderController {
    private final ProviderService providerService;
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }
    @PostMapping
    public ProviderDTO saveProvider(@RequestBody Provider provider){
        return providerService.addProvider(provider);
    }
    @GetMapping("{id}")
    public ProviderDTO getById(@PathVariable Long id){
        return (ProviderDTO) providerService.getByProviderId(id);
    }
    @GetMapping
    public Collection<ProviderDTO> getAllProviders(){
        return providerService.getAllProviders();
    }
    @PatchMapping("{id}")
    public ProviderDTO updateProvider(@PathVariable("id") Long id, @RequestBody ProviderDTO providerDTO){
        return providerService.updateProvider(id, providerDTO);
    }
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id){
        return providerService.delete(id);
    }
    @GetMapping("/provider_by_title")
    public ProviderDTO getByTitle(@RequestParam("title") String title){
        return providerService.getByTitle(title);
    }
    @GetMapping("/provider_by_email")
    public ProviderDTO getByEmail(@RequestParam("email") String email){
        return providerService.getByEmail(email);
    }
    @GetMapping("/provider_by_country")
    public Collection<ProviderDTO> getByCountry(@RequestParam("country") String country){
        return providerService.getByCountry(country);
    }
    @GetMapping("/provider_by_city")
    public Collection<ProviderDTO> getProviderByCity(@RequestParam("city") String city){
        return providerService.getByCity(city);
    }
    @GetMapping("/provider_by_phonenumber")
    public ProviderDTO getByPhoneNumber( @RequestParam("phoneNumber") String phoneNumber){
        return providerService.getByPhoneNumber(phoneNumber);
    }
}

package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.impl;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.OpportunityRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dao.ProviderRepository;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.OpportunityDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.ProviderDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Provider;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces.ProviderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;
    private  final OpportunityRepository opportunityRepository;
    private ModelMapper modelMapper;

    public ProviderServiceImpl(ProviderRepository providerRepository, OpportunityRepository opportunityRepository, ModelMapper modelMapper) {
        this.providerRepository = providerRepository;
        this.opportunityRepository = opportunityRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * @param provider
     * @return
     */
    @Override
    public ProviderDTO addProvider(Provider provider) {
        providerRepository.save(provider);
        ProviderDTO providerDTO =modelMapper.map(provider, ProviderDTO.class);
        return providerDTO;
    }
    /**
     * @param id
     * @return
     */
    @Override
    public ProviderDTO getById(Long id) {
        Optional<Provider> p= providerRepository.findById(id);
        ProviderDTO providerDTO = modelMapper.map(p, ProviderDTO.class);
        return providerDTO;
    }

    /**
     * @return
     */
    @Override
    public Collection<ProviderDTO> getAllProviders() {
        Collection<ProviderDTO> providerDTOS =providerRepository.findAll()
                .stream().map(provider -> modelMapper.map(provider,ProviderDTO.class)).collect(Collectors.toList());
        return providerDTOS ;
    }

    /**
     * @param id
     * @param providerDTO
     * @return
     */
    @Override
    public ProviderDTO updateProvider(Long id, ProviderDTO providerDTO) {
        Provider provider= providerRepository.findById(id).get();
        provider.setDescription(providerDTO.getDescription());
        provider.setTitle(providerDTO.getTitle());
        provider.setCity(providerDTO.getCity());
        provider.setCountry(providerDTO.getCountry());
        provider.setEmail(providerDTO.getEmail());
        providerDTO.setPhoneNumber(providerDTO.getPhoneNumber());
        providerRepository.save(provider);
        ProviderDTO providerDTO1 = modelMapper.map(provider, ProviderDTO.class);
        return providerDTO1;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean delete(Long id) {
        try {
            Provider provider = (Provider) providerRepository.findAll().stream().filter(p->p.getId().equals(id));
            providerRepository.findAll().remove(providerRepository.findById(id));

        } catch (RuntimeException e){
            e.printStackTrace();
        }
        return true;
    }

    /**
     * @param providerId
     * @return
     */
    @Override
    public Collection<OpportunityDTO> getByProviderId(Long providerId) {
        Collection<OpportunityDTO> opportunityDTOS = opportunityRepository
                                                        .findByProviderId(providerId)
                                                            .stream().map(op->modelMapper.map(op, OpportunityDTO.class))
                                                                .collect(Collectors.toList());
        return opportunityDTOS;
    }

    /**
     * @param title
     * @return
     */
    @Override
    public ProviderDTO getByTitle(String title) {
        Provider provider = providerRepository.findByTitle(title);
        ProviderDTO providerDTO = modelMapper.map(provider,ProviderDTO.class);
        return providerDTO;
    }

    /**
     * @param email
     * @return
     */
    @Override
    public ProviderDTO getByEmail(String email) {
        Provider provider = providerRepository.findByEmail(email);
        ProviderDTO providerDTO = modelMapper.map(provider,ProviderDTO.class);
        return providerDTO;
    }

    /**
     * @param city
     * @return
     */
    @Override
    public Collection<ProviderDTO> getByCity(String city) {
        Collection<ProviderDTO> providerDTOS= providerRepository.findByCity(city)
                .stream()
                .map(provider -> modelMapper
                        .map(provider, ProviderDTO.class))
                .collect(Collectors.toList());
        return providerDTOS;
    }

    /**
     * @param country
     * @return
     */
    @Override
    public Collection<ProviderDTO> getByCountry(String country) {
        Collection<ProviderDTO> providerDTOS= providerRepository.findByCountry(country)
                                                .stream()
                                                    .map(provider -> modelMapper
                                                            .map(provider, ProviderDTO.class))
                                                                .collect(Collectors.toList());
        return providerDTOS;
    }

    /**
     * @param phoneNumber
     * @return
     */
    @Override
    public ProviderDTO getByPhoneNumber(String phoneNumber) {
        Provider provider=providerRepository.findByPhoneNumber(phoneNumber);
        ProviderDTO providerDTO = modelMapper.map(provider,ProviderDTO.class);
        return providerDTO;
    }
}

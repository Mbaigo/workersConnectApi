package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.OpportunityDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.dto.ProviderDTO;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Provider;

import java.util.Collection;

public interface ProviderService {
    public ProviderDTO addProvider(Provider provider);
    public ProviderDTO getById(Long id);
    public Collection<ProviderDTO> getAllProviders();
    public ProviderDTO updateProvider(Long id, ProviderDTO providerDTO);
    public boolean delete(Long id);
    public Collection<OpportunityDTO> getByProviderId(Long providerId);
    public ProviderDTO getByTitle(String title);
    public ProviderDTO getByEmail(String email);
}

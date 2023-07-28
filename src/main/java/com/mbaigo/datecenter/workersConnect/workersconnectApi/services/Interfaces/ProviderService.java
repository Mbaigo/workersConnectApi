package com.mbaigo.datecenter.workersConnect.workersconnectApi.services.Interfaces;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Opportunity;
import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Provider;

import java.util.Collection;

public interface ProviderService {
    public Provider addProvider(Provider provider);
    public Provider getById(Long id);
    public Collection<Provider> getAllProviders();
    public Provider updateProvider(Long id);
    public boolean delete(Long id);
    public Collection<Opportunity> getByProviderId(Long providerId);
    public Provider getByTitle(String title);
    public Provider getByEmail(String email);
}

package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    public Provider getByEmail(String email);
    public Provider getByTitle(String title);
    public Collection<Provider> getByLocation(String location);
    public Provider getByPhoneNumber(String phoneNumber);
}

package com.mbaigo.datecenter.workersConnect.workersconnectApi.dao;

import com.mbaigo.datecenter.workersConnect.workersconnectApi.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
    public Provider findByEmail(String email);
    public Provider findByTitle(String title);
    public Collection<Provider> findByLocation(String location);
    public Provider findByPhoneNumber(String phoneNumber);
}

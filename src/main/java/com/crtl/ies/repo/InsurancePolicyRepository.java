package com.crtl.ies.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crtl.ies.model.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer>{

}

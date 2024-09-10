package com.crtl.ies.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crtl.ies.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}

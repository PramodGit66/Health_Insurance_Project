package com.crtl.ies.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crtl.ies.dto.ClaimDto;
import com.crtl.ies.dto.InsurancePolicyDto;
import com.crtl.ies.exception.ResourceNotFoundException;
import com.crtl.ies.model.Claim;
import com.crtl.ies.repo.ClaimRepository;
import com.crtl.ies.repo.InsurancePolicyRepository;

@Service
public class ClaimServiceImpl implements ClaimService {

	private ClaimRepository claimRepository;
	private InsurancePolicyService insurancePolicyService;
	private InsurancePolicyRepository insurancePolicyRepository;
	private ModelMapper modelMapper;

	
	@Autowired
	public ClaimServiceImpl(ClaimRepository claimRepository, InsurancePolicyService insurancePolicyService,
			InsurancePolicyRepository insurancePolicyRepository, ModelMapper modelMapper) {
		this.claimRepository = claimRepository;
		this.insurancePolicyService = insurancePolicyService;
		this.insurancePolicyRepository = insurancePolicyRepository;
		this.modelMapper = modelMapper;
	}

	
	

	@Override
	public Claim createNewClaim(Integer policyId, ClaimDto claim) {
		InsurancePolicyDto policy = insurancePolicyService.getById(policyId);
//		System.out.println(policy);
//		Set<ClaimDto> claims = policy.getClaims();
//		claims.add(claim);
//		policy.setClaims(claims);
//		claim.setPolicy(policy);

//		insurancePolicyRepository.save(modelMapper.map(policy, InsurancePolicy.class));

		Claim claimd = modelMapper.map(claim, Claim.class);
		return claimRepository.save(claimd);
	}

	@Override
	public Claim getClaimById(Integer claimId) {
		return claimRepository.findById(claimId)
				.orElseThrow(() -> new ResourceNotFoundException("Claim ", "Claim id", "" + claimId));
	}

	@Override
	public Claim updateClaim(Claim claim, Integer claimId) {
		Claim claime = claimRepository.findById(claimId)
				.orElseThrow(() -> new ResourceNotFoundException("Claim ", "Claim id", "" + claimId));
		Claim newClaim = modelMapper.map(claim, Claim.class);
		//newClaim.setId(claimId);
		newClaim.setClaimDate(claime.getClaimDate());
		return claimRepository.save(newClaim);
	}

	@Override
	public String deleteClaim(Integer claimId) {
		Claim claim = claimRepository.findById(claimId)
				.orElseThrow(() -> new ResourceNotFoundException("Claim ", "Claim id", "" + claimId));
		claimRepository.delete(claim);
		return "claim info delete successfully...";
	}

	@Override
	public List<Claim> getAllClaim() {
		return claimRepository.findAll();
	}

}

package com.crtl.ies.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsurancePolicyDto {

	@Id
    private Integer id;

    @NotBlank(message = "Policy Number is required")
    private String policyNumber;

    @NotBlank(message = "Policy Type is required")
    private String policyType;

    @NotNull(message = "Coverage Amount is required")
    @Positive(message = "Coverage Amount must be a positive number")
    private BigDecimal coverageAmount;

    @NotNull(message = "Premium is required")
    @Positive(message = "Premium must be a positive number")
    private BigDecimal premium;

    @NotNull(message = "Start Date is required")
    private LocalDate startDate;

    @NotNull(message = "End Date is required")
    private LocalDate endDate;
    

    private Client client;

    private Set<ClaimDto> claims = new HashSet<>();
}

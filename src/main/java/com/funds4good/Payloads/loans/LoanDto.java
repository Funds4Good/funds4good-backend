package com.funds4good.Payloads.loans;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
    private String name;
    private String zipcode;
    private String bio;
    private String occupation;
    private String income;
    private String idDetails;
    private String idNumber;
    private Double loanAmount;
    private String loanCategory;
    private String loanDuration;
    private String loanDurationUnit;
    private String loanDescription;
    private String repaymentStartDate;
    private String emiRepetition;
}

package com.funds4good.Models.loans;

import com.funds4good.Models.User;
import com.funds4good.Payloads.loans.LoanDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String loanRequestId;
    private String name;
    private String zipcode;
    private String bio;
    private String occupation;
    private String income;
    private String idDetails;
    private String idNumber;
    private String imageUploaded;
    private Double loanAmount;
    private String loanCategory;
    private String timeDuration;
    private String loanDescription;
    private String repaymentStartDate;
    private String emiRepetition;
    private String userId;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Loan(LoanDto loanDto, String imagePath, User user) {
        this.name = loanDto.getName();
        this.zipcode = loanDto.getZipcode();
        this.bio = loanDto.getBio();
        this.occupation = loanDto.getOccupation();
        this.income = loanDto.getIncome();
        this.idDetails = loanDto.getIdDetails();
        this.idNumber = loanDto.getIdNumber();
        this.imageUploaded = imagePath;
        this.loanAmount = loanDto.getLoanAmount();
        this.loanCategory = loanDto.getLoanCategory();
        this.timeDuration = loanDto.getTimeDuration();
        this.loanDescription = loanDto.getLoanDescription();
        this.repaymentStartDate = loanDto.getRepaymentStartDate();
        this.emiRepetition = loanDto.getEmiRepetition();
        this.userId = user.getUsername();
    }
}

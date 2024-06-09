package com.funds4good.Service;

import com.funds4good.Models.User;
import com.funds4good.Models.loans.Loan;
import com.funds4good.Payloads.loans.LoanDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LoanService {
    Loan createLoan(LoanDto loanDto, MultipartFile image, User user);

    void bookMark(User user, String id);

    List<Loan> getUserLoans(User user);

    List<Loan> getUserBookMarkLoans(User user);

    List<Loan> getAllLoans(String category);
}

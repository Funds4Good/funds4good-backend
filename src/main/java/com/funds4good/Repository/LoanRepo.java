package com.funds4good.Repository;

import com.funds4good.Models.loans.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoanRepo extends JpaRepository<Loan, String> {

    @Query("SELECT l FROM Loan l order by l.createdAt desc")
    List<Loan> findAllLoans();

    List<Loan> findByUserId(String userId);

    @Query("SELECT l FROM Loan l WHERE l.loanCategory = :category order by l.createdAt desc")
    List<Loan> findByLoanCategory(@Param("category") String category);
}

//package com.funds4good.Service.Impl;
//
//import com.funds4good.Models.loans.Loan;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class CreditScoreService {
//    public static int calculateCreditScore(List<Loan> loans, int creditReportCount) {
//        int score = 0;
//        double onTimePayments = calculateOnTimePayments(loans);
//        double paymentHistoryScore = calculatePaymentHistoryScore(onTimePayments, loans.size());
//        double creditUtilization = calculateCreditUtilization(loans);
//        double creditHistoryScore = calculateCreditHistoryScore(loans);
//        double creditTypesScore = calculateCreditTypesScore(loans);
//        double newCreditScore = calculateNewCreditScore(loans);
//        double creditReportAdjustment = adjustScoreBasedOnCreditReportCount(creditReportCount);
//        score = (int) ((paymentHistoryScore + creditUtilization + creditHistoryScore + creditTypesScore + newCreditScore + creditReportAdjustment) / 6);
//        return score;
//    }
//
//    double calculateOnTimePayments(List<Loan> loans) {
//        double onTimePayments = 0;
//        for (Loan loan : loans) {
//            if (loan..equals("on-time")) {
//                onTimePayments++;
//            }
//        }
//        return onTimePayments;
//    }
//
//    double calculatePaymentHistoryScore(double onTimePayments, int totalLoans) {
//        return (onTimePayments / totalLoans) * 100;
//    }
//
//    double calculateCreditUtilization(List<Loan> loans) {
//        double creditUtilization = 0;
//        for (Loan loan : loans) {
//            creditUtilization += loan.getLoanAmount() / loan.getCreditLimit();
//        }
//        return creditUtilization;
//    }
//
//    double calculateCreditHistoryScore(List<Loan> loans) {
//        double creditHistoryScore = 0;
//        for (Loan loan : loans) {
//            creditHistoryScore += loan.getLoanAmount() / loan.getCreditLimit();
//        }
//        return creditHistoryScore;
//    }
//
//    double calculateCreditTypesScore(List<Loan> loans) {
//        double creditTypesScore = 0;
//        for (Loan loan : loans) {
//            creditTypesScore += loan.getLoanAmount() / loan.getCreditLimit();
//        }
//        return creditTypesScore;
//    }
//
//    double calculateNewCreditScore(List<Loan> loans) {
//        double newCreditScore = 0;
//        for (Loan loan : loans) {
//            newCreditScore += loan.getLoanAmount() / loan.getCreditLimit();
//        }
//        return newCreditScore;
//    }
//
//    double adjustScoreBasedOnCreditReportCount(int creditReportCount) {
//        if (creditReportCount < 3) {
//            return 0;
//        } else if (creditReportCount < 6) {
//            return 10;
//        } else if (creditReportCount < 9) {
//            return 20;
//        } else {
//            return 30;
//        }
//    }
//}

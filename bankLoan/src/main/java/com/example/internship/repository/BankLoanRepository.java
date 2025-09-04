package com.example.internship.repository;

import com.example.internship.entity.BankLoanForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankLoanRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void create(BankLoanForm bankLoanForm) {
        String sql = "INSERT INTO bankLoan_table(bankName, branchName, subjectName, bankAccountNum, debtorName, loanType, loanAmount," +
                " borrowingIncome, loanTerm, interestRate ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, bankLoanForm.getBankName(),bankLoanForm.getBranchName(), bankLoanForm.getSubjectName(),
        bankLoanForm.getBankAccountNum(), bankLoanForm.getDebtorName(), bankLoanForm.getLoanType(),
                bankLoanForm.getLoanAmount(), bankLoanForm.getBorrowingIncome(), bankLoanForm.getLoanTerm(), bankLoanForm.getInterestRate());
    }

}

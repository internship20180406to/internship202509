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
        String sql = "INSERT INTO bankLoan_table(bankName,branchName,bankKinds,bankAccountNum,debtorName,birthday,address,phoneNumber,mailAddress,occupation,workPlace,housingKinds,loanAmount,borrowingIncome,loanPeriod,interestRate) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                bankLoanForm.getBankName(),
                bankLoanForm.getBranchName(),
                bankLoanForm.getBankKinds(),
                bankLoanForm.getBankAccountNum(),
                bankLoanForm.getDebtorName(),
                bankLoanForm.getBirthday(),
                bankLoanForm.getAddress(),
                bankLoanForm.getPhoneNumber(),
                bankLoanForm.getMailAddress(),
                bankLoanForm.getOccupation(),
                bankLoanForm.getWorkPlace(),
                bankLoanForm.getHousingKinds(),
                bankLoanForm.getLoanAmount(),
                bankLoanForm.getBorrowingIncome(),
                bankLoanForm.getInterestRate(),
                bankLoanForm.getLoanPeriod()
        );
    }

}

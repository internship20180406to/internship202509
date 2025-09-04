package com.example.internship.repository;

import com.example.internship.entity.InvestmentTrustForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class InvestmentTrustRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void create(InvestmentTrustForm investmentTrustForm) {
        String sql = "INSERT INTO investmentTrust_table(bankName, bankAccountNum,branchName,bankAccountType,name,fundName,money) VALUES(?, ?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
        investmentTrustForm.getBankName(),
        investmentTrustForm.getBankAccountNum(),
        investmentTrustForm.getBranches(),
        investmentTrustForm.getBankType(),
        investmentTrustForm.getCustomerName(),
        investmentTrustForm.getStockName(),
        investmentTrustForm.getPurchaseAmount());

        //System.out.println(investmentTrustForm.getBankType());
    }
}

package com.example.internship.repository;

import com.example.internship.entity.InvestmentTrustForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvestmentTrustRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void create(InvestmentTrustForm investmentTrustForm) {
        String sql = "INSERT INTO investmentTrust_table(bankName, bankAccountNum) VALUES(?, ?)";
        jdbcTemplate.update(sql, investmentTrustForm.getBankName(), investmentTrustForm.getBankAccountNum());
    }

    public List<String> findAllBankNames() {
        String sql = "SELECT bankName FROM bankName_table ORDER BY id";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<String> findBranchesByBankName(String bankName) {
        String sql = "SELECT bb.bankBrancName " +
                "FROM bankBranchName_table bb " +
                "JOIN bankName_table b ON bb.bankId = b.id " +
                "WHERE b.bankName = ? " +
                "ORDER BY bb.id";
        return jdbcTemplate.queryForList(sql, String.class, bankName);
    }

}

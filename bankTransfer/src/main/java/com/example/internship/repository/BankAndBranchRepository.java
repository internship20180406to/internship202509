package com.example.internship.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BankAndBranchRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void getBankAndBranch() {
        String sql = "SELECT bankName, branchName FROM bankAndBranch_table";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        for ( Map<String, Object> row:result) {
            String bankName = (String) row.get("bankName");
            String branchName = (String) row.get("branchName");

            System.out.println("Bank: " + bankName + ", Branch: " + branchName);
        }
    }

}

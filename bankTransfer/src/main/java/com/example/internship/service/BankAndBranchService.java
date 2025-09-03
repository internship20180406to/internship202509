package com.example.internship.service;

import com.example.internship.repository.BankAndBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankAndBranchService {
    @Autowired
    private BankAndBranchRepository bankAndBranchRepository;

    public void callGetBankAndBranch() {
        bankAndBranchRepository.getBankAndBranch();
    }
}

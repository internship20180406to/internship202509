package com.example.internship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankLoanForm {
    @NonNull
    private String bankName;
    @NonNull
    private String branchName;
    @NonNull
    private String accountName;
    @NonNull
    private String debtorName;
    @NonNull
    private String loanAmount;
    @NonNull
    private String borrowingIncome;
    @NonNull
    private String interestRate;
    @NonNull
    private Integer bankAccountNum;

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    // Getter & Setter for branchName
    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    // Getter & Setter for accountName
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    // Getter & Setter for bankAccountNum
    public Integer getBankAccountNum() {
        return bankAccountNum;
    }
    public void setBankAccountNum(Integer bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    // Getter & Setter for debtorName
    public String getDebtorName() {
        return debtorName;
    }
    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    // Getter & Setter for loanAmount
    public String getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Getter & Setter for borrowingIncome
    public String getBorrowingIncome() {
        return borrowingIncome;
    }
    public void setBorrowingIncome(String borrowingIncome) {
        this.borrowingIncome = borrowingIncome;
    }

    // Getter & Setter for interestRate
    public String getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }
}


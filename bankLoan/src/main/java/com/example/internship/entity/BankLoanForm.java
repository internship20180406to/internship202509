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
    private Integer branchName;
    @NonNull
    private String bankKinds;
    @NonNull
    private String debtorName;
    @NonNull
    private Integer loanAmount;
    @NonNull
    private Integer borrowingIncome;
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
    public Integer getBranchName() {
        return branchName;
    }
    public void setBranchName(Integer branchName) {
        this.branchName = branchName;
    }

    // Getter & Setter for accountName
    public String getBankKinds() {
        return bankKinds;
    }
    public void setAccountName(String bankKinds) {
        this.bankKinds = bankKinds;
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
    public Integer getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Getter & Setter for borrowingIncome
    public Integer getBorrowingIncome() {
        return borrowingIncome;
    }
    public void setBorrowingIncome(Integer borrowingIncome) {
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


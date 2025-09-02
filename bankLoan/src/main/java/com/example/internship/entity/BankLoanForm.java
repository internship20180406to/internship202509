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
    private String subjectName;
    @NonNull
    private Integer bankAccountNum;
    @NonNull
    private String debtorName;
    @NonNull
    private String loanAmount;
    @NonNull
    private String borrowingIncome;
    @NonNull
    private String interestRate;
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getBorrowingIncome() {
        return borrowingIncome;
    }

    public void setBorrowingIncome(String borrowingIncome) {
        this.borrowingIncome = borrowingIncome;
    }


    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(Integer bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }
}

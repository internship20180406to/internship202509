package com.example.internship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankTransferForm {
    @NonNull
    private String bankName;
    @NonNull
    private Integer bankAccountNum;
    private String branchName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public Integer getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(Integer bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    public Integer getBranchName() {
        return bankAccountNum;
    }

    public void setBranchName(Integer bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }
}

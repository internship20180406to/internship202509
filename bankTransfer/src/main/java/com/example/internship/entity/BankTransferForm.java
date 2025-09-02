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

    public String getBranchName() {return branchName;}

    //エラー出るやつ(勝手に推測してる)
    //public void setBranchName(Integer bankAccountNum) { this.bankAccountNum = bankAccountNum;}

    public void setBranchName(String branchName) {this.branchName = branchName;}
}

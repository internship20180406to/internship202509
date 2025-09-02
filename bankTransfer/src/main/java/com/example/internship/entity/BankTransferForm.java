package com.example.internship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankTransferForm {

    @NonNull
    private String bankName;
    @NonNull
    private String branchName;
    @NonNull
    private String subjectName;
    @NonNull
    private Integer bankAccountNum;
    @NonNull
    private String name;
    @NonNull
    private Integer money;
    @NonNull
    private Date date;

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public String getBranchName() {return branchName;}
    public void setBranchName(String branchName) {this.branchName = branchName;}
    //エラー出るやつ(勝手に推測してる)
    //public void setBranchName(Integer bankAccountNum) { this.bankAccountNum = bankAccountNum;}

    public String getSubjectName() {return subjectName;}
    public void setSubjectName(String subjectName) {this.subjectName = subjectName;}

    public Integer getBankAccountNum() {return bankAccountNum;}
    public void setBankAccountNum(Integer bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Integer getMoney() {return money;}
    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}
}

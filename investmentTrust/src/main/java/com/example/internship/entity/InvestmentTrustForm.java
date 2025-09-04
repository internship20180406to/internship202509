package com.example.internship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentTrustForm {

    @NonNull
    private String bankName;
    @NonNull
    private String bankAccountNum;
    @NonNull
    private String branchName;
    @NonNull
    private String bankAccountType;

    @NonNull
    private String name;
    @NonNull
    private String fundName;

    @NonNull
    private String money;

    @NonNull
    private String methodName;

    @NonNull
    private String unit;


    @NonNull
    private String nav;



    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(String bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    public String getBranchName() { return branchName;}

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBankAccountType() { return bankAccountType;}

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public String getNav(){ return nav; }
    public void setNav(String nav) {
        this.nav = nav;
    }

}

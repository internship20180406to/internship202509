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
    private Integer bankAccountNum;
    @NonNull
    private String Branches;
    @NonNull
    private String CustomerName;
    @NonNull
    private String StockName;
    @NonNull
    private String BankType;
    @NonNull
    private Integer PurchaseAmount;


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

    public String getBranches() {
        return Branches;
    }

    public void setBranches(String Branches) {
        this.Branches = Branches;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getBankType() {
        return BankType;
    }

    public void setBankType(String BankType) {
        this.BankType = BankType;
    }

    public String getStockName() { return StockName;}

    public void setStockName(String StockName) {
        this.StockName = StockName;
    }

    public Integer getPurchaseAmount() {
        return PurchaseAmount;
    }

    public void setPurchaseAmount(Integer PurchaseAmount) {
        this.PurchaseAmount = PurchaseAmount;
    }

}

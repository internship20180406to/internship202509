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
    private String ShopName;

    @NonNull
    private String Subject;

    @NonNull
    private Integer bankAccountNum;

    @NonNull
    private String Purchaser;

    @NonNull
    private String BrandName;

    @NonNull
    private Integer amount;



    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }


    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public Integer getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(Integer bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    public String getPurchaser() {
        return Purchaser;
    }

    public void setPurchaser(String Purchaser) {
        this.Purchaser = Purchaser;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}


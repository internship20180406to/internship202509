package com.example.internship.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.NonNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.convert.DataSizeUnit;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentTrustForm {
    @NotBlank
    private String bankName;

    @NotBlank
    private String ShopName;

    @NotBlank
    private String Subject;

    @NotNull(message = "口座番号を入力してください")
    @Digits(integer = 7, fraction = 0, message = "7ケタで入力してください")
    private Integer bankAccountNum;

    @NotBlank
    private String Purchaser;

    @NotBlank
    private String BrandName;

    @NotNull(message = "購入金額を入力してください")
    @Min(value = 1, message = "金額は1以上で入力してください")
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


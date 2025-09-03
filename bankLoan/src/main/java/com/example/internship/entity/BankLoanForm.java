package com.example.internship.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankLoanForm {

    @NotBlank(message = "銀行を選択してください")
    private String bankName;

    @NotNull(message="支店コードを入力してください")
    @Min(value = 0, message = "支店コードは0以上です")
    @Max(value = 999, message = "支店コードは3桁以内です")
    private String branchName;

    @NotBlank(message="科目名を選択してください")
    private String bankKinds;

    @NotBlank(message="名前を入力してください")
    private String debtorName;

    @NotNull(message="借入金額を入力してください")
    @Min(value = 1, message = "借入金額は1以上で入力してください")
    private Integer loanAmount;

    @NotNull(message="年収を入力してください")
    @Min(value = 0, message = "年収は0以上で入力してください")
    private Integer borrowingIncome;

    @NotBlank(message="金利を入力してください")
    private String interestRate;

    @NotNull(message="口座番号を入力してください")
    @Min(value = 0, message = "口座番号は0以上です")
    @Max(value = 99999999, message = "口座番号は8桁以内です")
    private Integer bankAccountNum;

    @NonNull
    private String birthday;

    @NonNull
    private String address;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String mailAddress;

    @NonNull
    private String occupation;

    @NonNull
    private String workPlace;

    @NonNull
    private String housingKinds;

    @NonNull
    private Integer loanPeriod;

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

    // Getter & Setter for birthday
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public String getHousingKinds() {
        return housingKinds;
    }

    public Integer getLoanPeriod() {
        return loanPeriod;
    }
}




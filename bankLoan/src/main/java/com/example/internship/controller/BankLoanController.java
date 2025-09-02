package com.example.internship.controller;

import com.example.internship.entity.BankLoanForm;
import com.example.internship.service.ApplyBankLoanService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Arrays;




@Controller
public class BankLoanController {

    @Autowired
    private ApplyBankLoanService applyBankLoanService;

    @GetMapping("/bankLoan")
    public String bankTransfer(Model model) {
        List<String> nameOptions = Arrays.asList(
                "選択してください",
                "山陰共同銀行",
                "北海道中央銀行",
                "東京銀行",
                "横浜共同銀行");
        List<String> accountOptions = Arrays.asList(
                "選択してください",
                "普通預金",
                "定期預金",
                "当座預金",
                "貯蓄預金");
        model.addAttribute("bankLoanApplication", new BankLoanForm());
        model.addAttribute("nameOptions", nameOptions);
        model.addAttribute("accountOptions", accountOptions);
        return "bankLoanMain";
    }

    @PostMapping("/bankLoanConfirmation")
    public String confirmation(@ModelAttribute BankLoanForm bankLoanForm, Model model,BindingResult result) {
        if(result.hasErrors()) {
            return "bankLoanMain";
        }
        model.addAttribute("bankName", bankLoanForm.getBankName());
        model.addAttribute("branchName", bankLoanForm.getBranchName());
        model.addAttribute("bankKinds", bankLoanForm.getBankKinds());
        model.addAttribute("bankAccountNum", bankLoanForm.getBankAccountNum());
        model.addAttribute("debtorName", bankLoanForm.getDebtorName());
        model.addAttribute("birthday", bankLoanForm.getBirthday());
        model.addAttribute("loanAmount", bankLoanForm.getLoanAmount());
        model.addAttribute("borrowingIncome", bankLoanForm.getBorrowingIncome());
        model.addAttribute("interestRate", bankLoanForm.getInterestRate());
        model.addAttribute("bankLoanApplication", bankLoanForm);
        return "bankLoanConfirmation";
    }



    @PostMapping("/bankLoanCompletion")
    public String completion(@ModelAttribute BankLoanForm bankLoanForm, Model model) {
        applyBankLoanService.applyBankLoan(bankLoanForm);
        return "bankLoanCompletion";
    }



}

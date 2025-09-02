package com.example.internship.controller;

import com.example.internship.entity.BankLoanForm;
import com.example.internship.service.ApplyBankLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BankLoanController {

    @Autowired
    private ApplyBankLoanService applyBankLoanService;

    @GetMapping("/bankLoan")
    public String bankTransfer(Model model) {
        model.addAttribute("bankLoanApplication", new BankLoanForm());
        List<String> nameOptions = new ArrayList<String>();
        nameOptions.add("選択してください");
        nameOptions.add("綾鷹銀行");
        nameOptions.add("ハイチュウ銀行");
        nameOptions.add("アルフォート銀行");

        List<String> subjectOptions = new ArrayList<String>();
        subjectOptions.add("選択してください");
        subjectOptions.add("普通");
        subjectOptions.add("定期");
        subjectOptions.add("当座");
        subjectOptions.add("貯蓄");

        model.addAttribute("nameOptions",nameOptions);
        model.addAttribute("subjectOptions",subjectOptions);
        return "bankLoanMain";
    }

    @PostMapping("/bankLoanConfirmation")
    public String confirmation(@ModelAttribute BankLoanForm bankLoanForm, Model model) {

        model.addAttribute("bankName", bankLoanForm.getBankName());
        model.addAttribute("branchName", bankLoanForm.getBranchName());
        model.addAttribute("subjectName", bankLoanForm.getSubjectName());
        model.addAttribute("bankAccountNum", bankLoanForm.getBankAccountNum());
        model.addAttribute("debtorName", bankLoanForm.getDebtorName());
        model.addAttribute("loanAmount", bankLoanForm.getLoanAmount());
        model.addAttribute("borrowingIncome", bankLoanForm.getBorrowingIncome());
        model.addAttribute("interestRate", bankLoanForm.getInterestRate());
        model.addAttribute("bankLoanApplication", bankLoanForm);
        System.out.println(bankLoanForm.getBranchName());
        return "bankLoanConfirmation";
    }

    @PostMapping("/bankLoanCompletion")
    public String completion(@ModelAttribute BankLoanForm bankLoanForm, Model model) {
        applyBankLoanService.applyBankLoan(bankLoanForm);
        return "bankLoanCompletion";
    }

}

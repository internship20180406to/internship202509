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
        nameOptions.add("a銀行");
        nameOptions.add("b銀行");
        nameOptions.add("c銀行");
        nameOptions.add("d銀行");

        List<String> subjectOptions = new ArrayList<String>();
        subjectOptions.add("普通");
        subjectOptions.add("定期");
        subjectOptions.add("当座");
        subjectOptions.add("貯蓄");

        List<String> loanOptions = new ArrayList<String>();
        loanOptions.add("自動車ローン");
        loanOptions.add("住宅ローン");
        loanOptions.add("学費ローン");

        model.addAttribute("nameOptions",nameOptions);
        model.addAttribute("subjectOptions",subjectOptions);
        model.addAttribute("loanOptions",loanOptions);
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
        model.addAttribute("loanType", bankLoanForm.getLoanType());
        model.addAttribute("borrowingIncome", bankLoanForm.getBorrowingIncome());
        model.addAttribute("interestRate", bankLoanForm.getInterestRate());
        model.addAttribute("loanTerm", bankLoanForm.getLoanTerm());
        model.addAttribute("bankLoanApplication", bankLoanForm);



        return "bankLoanConfirmation";
    }

    @PostMapping("/bankLoanCompletion")
    public String completion(@ModelAttribute BankLoanForm bankLoanForm, Model model) {
        applyBankLoanService.applyBankLoan(bankLoanForm);
        return "bankLoanCompletion";
    }

}

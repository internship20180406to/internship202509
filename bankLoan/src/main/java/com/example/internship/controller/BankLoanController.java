package com.example.internship.controller;

import com.example.internship.entity.BankLoanForm;
import com.example.internship.service.ApplyBankLoanService;
import org.springframework.validation.BindingResult;
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
                "新潟信用銀行",
                "富山中央銀行",
                "金沢銀行",
                "福井恐竜銀行");
        List<String> accountOptions = Arrays.asList(
                "普通預金",
                "定期預金",
                "当座預金",
                "貯蓄預金");
        List<String> houseOptions = Arrays.asList(
                "持ち家",
                "賃貸マンション・借家",
                "公営住宅",
                "アパート",
                "社宅",
                "寮");
        List<String> occupationOptions = Arrays.asList(
                "会社員・上場",
                "会社員・非上場",
                "公務員",
                "自営業",
                "年金",
                "パート・アルバイト",
                "その他");
        model.addAttribute("bankLoanApplication", new BankLoanForm());
        model.addAttribute("nameOptions", nameOptions);
        model.addAttribute("accountOptions", accountOptions);
        model.addAttribute("houseOptions", houseOptions);
        model.addAttribute("occupationOptions",occupationOptions);
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
        model.addAttribute("address", bankLoanForm.getAddress());
        model.addAttribute("phoneNumber", bankLoanForm.getPhoneNumber());
        model.addAttribute("mailAddress", bankLoanForm.getMailAddress());
        model.addAttribute("occupation", bankLoanForm.getOccupation());
        model.addAttribute("workPlace", bankLoanForm.getWorkPlace());
        model.addAttribute("housingKinds", bankLoanForm.getHousingKinds());
        model.addAttribute("loanAmount", bankLoanForm.getLoanAmount());
        model.addAttribute("borrowingIncome", bankLoanForm.getBorrowingIncome());
        model.addAttribute("loanPeriod", bankLoanForm.getLoanPeriod());
        model.addAttribute("interestRate", bankLoanForm.getInterestRate());
        model.addAttribute("bankLoanApplication", bankLoanForm);

        double P = bankLoanForm.getLoanAmount() * 10000;
        double r = bankLoanForm.getInterestRate() / 100.0 / 12.0; // 月利
        int n = bankLoanForm.getLoanPeriod() * 12;

        double A = (r == 0) ? (P / n) : (P * r / (1 - Math.pow(1 + r, -n)));
        double total = A * n;

        model.addAttribute("monthlyPayment", Math.round(A));
        model.addAttribute("totalPayment", Math.round(total));
        return "bankLoanConfirmation";
    }



    @PostMapping("/bankLoanCompletion")
    public String completion(@ModelAttribute BankLoanForm bankLoanForm, Model model) {
        applyBankLoanService.applyBankLoan(bankLoanForm);
        return "bankLoanCompletion";
    }



}

package com.example.internship.controller;

import com.example.internship.entity.BankTransferForm;
import com.example.internship.service.ApplyBankTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BankTransferController {

    @Autowired
    private ApplyBankTransferService applyBankTransferService;

    @GetMapping("/bankTransfer")
    public String bankTransfer(Model model) {
        String[] bankname = {"A銀行", "B銀行", "C銀行", "D銀行"};
        String[] branchname = {"A支店", "B支店"};
//        String[] subjectname = {"普通","定期","当座","貯蓄"};
        model.addAttribute("bankTransferApplication", new BankTransferForm());
        model.addAttribute("nameOptions", bankname);
        model.addAttribute("nameOptions2", branchname);
//        model.addAttribute("nameOptions3", subjectname);
        return "bankTransferMain";
    }

    @PostMapping("/bankTransferConfirmation")
    public String confirmation(@ModelAttribute BankTransferForm bankTransferForm, Model model) {
       // bankTransferForm.setBankName("ながれぼし銀行");
        //System.out.println(bankTransferForm);
        //model.addAttribute("bankName", bankTransferForm.getBankName());
        //model.addAttribute("bankAccountNum", bankTransferForm.getBankAccountNum());
        //model.addAttribute("branchName", bankTransferForm.getBranchName());
        model.addAttribute("bankTransferApplication", bankTransferForm);
        return "bankTransferConfirmation";
    }

    @PostMapping("/bankTransferCompletion")
    public String completion(@ModelAttribute BankTransferForm bankTransferForm, Model model) {
        applyBankTransferService.applyBankTransfer(bankTransferForm);
        return "bankTransferCompletion";
    }

}

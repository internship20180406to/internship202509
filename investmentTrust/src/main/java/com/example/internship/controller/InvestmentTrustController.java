package com.example.internship.controller;

import com.example.internship.entity.InvestmentTrustForm;
import com.example.internship.service.OrderInvestmentTrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;


@Controller
public class InvestmentTrustController {

    @Autowired
    private OrderInvestmentTrustService orderInvestmentTrustService;

    @GetMapping("/investmentTrust")
    public String bankTransfer(Model model) {
        model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
        List<String> nameOptions = Arrays.asList("N銀行", "E銀行", "W銀行", "S銀行");
        model.addAttribute("nameOptions", nameOptions);
        List<String> SubjectOptions = Arrays.asList("普通", "貯蓄", "当座", "定期");
        model.addAttribute("SubjectOptions", SubjectOptions);
        List<String> BrandOptions = Arrays.asList("PONY", "任天丼", "パナソ肉");
        model.addAttribute("BrandOptions", BrandOptions);
        return "investmentTrustMain";
    }

    @PostMapping("/investmentTrustConfirmation")
    public String confirmation(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        model.addAttribute("bankName", investmentTrustForm.getBankName());
        model.addAttribute("ShopName", investmentTrustForm.getShopName());
        model.addAttribute("Subject", investmentTrustForm.getSubject());
        model.addAttribute("bankAccountNum", investmentTrustForm.getBankAccountNum());
        model.addAttribute("Purchaser", investmentTrustForm.getPurchaser());
        model.addAttribute("BrandName", investmentTrustForm.getBrandName());
        model.addAttribute("amount", investmentTrustForm.getAmount());
        model.addAttribute("investmentTrustApplication", investmentTrustForm);
        return "investmentTrustConfirmation";
    }

    @PostMapping("/investmentTrustCompletion")
    public String completion(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        orderInvestmentTrustService.orderInvestmentTrust(investmentTrustForm);
        return "investmentTrustCompletion";
    }

}

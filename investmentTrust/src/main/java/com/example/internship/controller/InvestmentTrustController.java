package com.example.internship.controller;

import com.example.internship.entity.InvestmentTrustForm;
import com.example.internship.repository.InvestmentTrustRepository;
import com.example.internship.service.OrderInvestmentTrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class InvestmentTrustController {

    @Autowired
    private OrderInvestmentTrustService orderInvestmentTrustService;

    @Autowired
    private InvestmentTrustRepository investmentTrustRepository;

    @GetMapping("/investmentTrust")
    public String bankTransfer(Model model) {
        try {
            List<String> bankNames = investmentTrustRepository.findAllBankNames();

            model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
            model.addAttribute("nameOptions", bankNames);

            return "investmentTrustMain";
        } catch (Exception e) {
            System.err.println("Error retrieving bank names: " + e.getMessage());
            e.printStackTrace();

            model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
            model.addAttribute("nameOptions", new ArrayList<>());
            return "investmentTrustMain";
        }
    }

    @GetMapping("/getBranches")
    @ResponseBody
    public List<String> getBranches(@RequestParam String bankName) {
        try {
            List<String> branches = investmentTrustRepository.findBranchesByBankName(bankName);
            return branches != null ? branches : new ArrayList<>();
        } catch (Exception e) {
            System.err.println("Error fetching branches for bank: " + bankName);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @PostMapping("/investmentTrustConfirmation")
    public String confirmation(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
//        investmentTrustForm.setBankName("ながれぼし銀行");
        model.addAttribute("bankName", investmentTrustForm.getBankName());
        model.addAttribute("bankAccountNum", investmentTrustForm.getBankAccountNum());
        model.addAttribute("investmentTrustApplication", investmentTrustForm);
        return "investmentTrustConfirmation";
    }

    @PostMapping("/investmentTrustCompletion")
    public String completion(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        orderInvestmentTrustService.orderInvestmentTrust(investmentTrustForm);
        return "investmentTrustCompletion";
    }

}

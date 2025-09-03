package com.example.internship.controller;

import com.example.internship.entity.InvestmentTrustForm;
import com.example.internship.service.OrderInvestmentTrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;


@Controller
public class InvestmentTrustController {

    @Autowired
    private OrderInvestmentTrustService orderInvestmentTrustService;

    @GetMapping("/investmentTrust")
    public String bankTransfer(Model model) {
//        List<String> list = new ArrayList<String>();
//        list.add("山陰共同銀行");
//        list.add("山陽共同銀行");
//        list.add("山中共同銀行");
//        model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
//        model.addAttribute("nameOptions", list);
//        model.addAttribute("branchOptions", "山支店");
//        model.addAttribute("branch2Options", "川支店");
//        model.addAttribute("branch3Options", "空支店");
        // 銀行リスト
        List<String> bankList = new ArrayList<String>();
        bankList.add("山陰共同銀行");
        bankList.add("山陽共同銀行");
        bankList.add("山中共同銀行");

        // 支店データをマップで管理（オプション1: サーバーサイド）
        Map<String, List<String>> branchMap = new HashMap<>();
        branchMap.put("山陰共同銀行", Arrays.asList("山支店", "陰支店", "北支店"));
        branchMap.put("山陽共同銀行", Arrays.asList("陽支店", "南支店", "西支店"));
        branchMap.put("山中共同銀行", Arrays.asList("川支店", "中支店", "東支店"));

        model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
        model.addAttribute("nameOptions", bankList);
        model.addAttribute("branchMap", branchMap);

        return "investmentTrustMain";
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

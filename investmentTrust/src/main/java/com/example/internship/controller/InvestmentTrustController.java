package com.example.internship.controller;

import com.example.internship.entity.InvestmentTrustForm;
import com.example.internship.service.OrderInvestmentTrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InvestmentTrustController {

    @Autowired
    private OrderInvestmentTrustService orderInvestmentTrustService;

    private static final Map<String, List<String>> branchMap = Map.of(
            "山陰共同銀行", List.of("うしうし支店", "ぶたぶた支店", "とりとり支店"),
            "海陰共同銀行", List.of("さんま支店", "いくら支店", "くじら支店")
    );

    private static final Map<String, String> navMap = Map.of(
            "鯨・グローバル・インデックス", "12,345",
            "イカロジック・テックセレクト", "12,345",
            "亀・ロングライフ・バランス", "12,345",
            "フクロウ・インサイト・ファンド", "12,345",
            "熊・ディフェンシブ・バリュー", "12,345",
            "モグラ・アンダーグラウンド・ストラテジー", "12,345"

    );


    @GetMapping("/investmentTrust")
    public String bankTransfer(Model model) {
        model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
        List<String> nameOptions = List.of("山陰共同銀行", "海陰共同銀行");
        model.addAttribute("nameOptions", nameOptions);
        return "investmentTrustMain";
    }

    @GetMapping("/getBranches")
    @ResponseBody
    public List<String> getBranches(@RequestParam String bankName) {
        return branchMap.getOrDefault(bankName, List.of());
    }

    @GetMapping("/getNav")
    @ResponseBody
    public String getNav(@RequestParam String fundName) {
        return navMap.getOrDefault(fundName, "取得不可");
    }

    @PostMapping("/investmentTrustConfirmation")
    public String confirmation(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        //investmentTrustForm.setBankName("ながれぼし銀行");
        model.addAttribute("bankName", investmentTrustForm.getBankName());
        model.addAttribute("branchName", investmentTrustForm.getBranchName());
        model.addAttribute("bankAccountType", investmentTrustForm.getBankAccountType());
        model.addAttribute("bankAccountNum", investmentTrustForm.getBankAccountNum());
        model.addAttribute("name", investmentTrustForm.getName());
        model.addAttribute("fundName", investmentTrustForm.getFundName());
        model.addAttribute("nav", investmentTrustForm.getNav());
        model.addAttribute("money", investmentTrustForm.getMoney());
        model.addAttribute("methodName", investmentTrustForm.getMethodName());
        model.addAttribute("unit", investmentTrustForm.getUnit());
        model.addAttribute("investmentTrustApplication", investmentTrustForm);
        return "investmentTrustConfirmation";
    }

    @PostMapping("/investmentTrustCompletion")
    public String completion(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        orderInvestmentTrustService.orderInvestmentTrust(investmentTrustForm);
        return "investmentTrustCompletion";
    }

}

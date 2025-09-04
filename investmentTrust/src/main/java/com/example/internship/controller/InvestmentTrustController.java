package com.example.internship.controller;

import com.example.internship.entity.InvestmentTrustForm;
import com.example.internship.service.OrderInvestmentTrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


@Controller
public class InvestmentTrustController {

    @Autowired
    private OrderInvestmentTrustService orderInvestmentTrustService;



    @GetMapping("/investmentTrust")
    public String bankTransfer(Model model) {

//        //金融機関名の候補を作成
//        List<String> Banks=new ArrayList<>();
//        Banks.add("山陰共同銀行");
//        Banks.add("海風共同銀行");
//        Banks.add("空雲共同銀行");
//
//        //支店名の候補を作成
//        List<String> Branches=new ArrayList<>();
//        Branches.add("001：まぐろ支店");
//        Branches.add("002：いわし支店");
//        Branches.add("003：ひらめ支店");
//        Branches.add("004：いくら支店");
//        Branches.add("005：かつお支店");
//        Branches.add("006：ほたて支店");
//        Branches.add("007：あなご支店");
//        Branches.add("008：はまち支店");
//        Branches.add("009：うに支店");

        Map<String,List<String>> Banks=new HashMap<>();

        Banks.put("山陰共同銀行",new ArrayList<>(List.of(
                "001：まぐろ支店",
                "002：いわし支店",
                "003：ひらめ支店"
        )));

        Banks.put("海風共同銀行",new ArrayList<>(List.of(
                "004：いくら支店",
                "005：かつお支店",
                "006：ほたて支店"
        )));

        Banks.put("空雲共同銀行",new ArrayList<>(List.of(
                "007：あなご支店",
                "008：はまち支店",
                "009：うに支店"
        )));

        List<String> BankType=new ArrayList<>();
        BankType.add("普通");
        BankType.add("定期");
        BankType.add("当座");
        BankType.add("貯蓄");
        BankType.add("その他");

        List<String> StockName=new ArrayList<>();
        StockName.add("M&H 500");
        StockName.add("G&P 200");
        StockName.add("J&T 1000");


        model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
        model.addAttribute("nameOptions", new ArrayList<>(Banks.keySet()));
        model.addAttribute("Branch_nameOptions", Banks);
        model.addAttribute("BankType_nameOptions", BankType);
        model.addAttribute("Stock_nameOptions", StockName);
        return "investmentTrustMain";
    }

    @PostMapping("/investmentTrustConfirmation")
    public String confirmation(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        //investmentTrustForm.setBankName("ながれぼし銀行");
        model.addAttribute("bankName", investmentTrustForm.getBankName());
        model.addAttribute("bankAccountNum", investmentTrustForm.getBankAccountNum());
        model.addAttribute("Branches", investmentTrustForm.getBranches());
        model.addAttribute("CustomerName", investmentTrustForm.getCustomerName());
        model.addAttribute("StockName", investmentTrustForm.getStockName());
        model.addAttribute("PurchaseAmount", investmentTrustForm.getPurchaseAmount());
        model.addAttribute("investmentTrustApplication", investmentTrustForm);
        return "investmentTrustConfirmation";
    }//確認画面で表示される情報

    @PostMapping("/investmentTrustCompletion")
    public String completion(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        orderInvestmentTrustService.orderInvestmentTrust(investmentTrustForm);
        return "investmentTrustCompletion";
    }

}

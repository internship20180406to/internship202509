package com.example.internship.controller;

import com.example.internship.entity.InvestmentTrustForm;
import com.example.internship.service.OrderInvestmentTrustService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@SessionAttributes("investmentTrustApplication")
public class InvestmentTrustController {

    @Autowired
    private OrderInvestmentTrustService orderInvestmentTrustService;

    @GetMapping("/investmentTrust")
    public String bankTransfer(Model model) {
        model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
        List<String> nameOptions = Arrays.asList("N銀行", "E銀行", "W銀行", "S銀行");
        model.addAttribute("nameOptions", nameOptions);

//        Map<String, List<String>> shopOptionsMap = new HashMap<>();
//        shopOptionsMap.put("N銀行", Arrays.asList("N1支店", "N2支店", "N3支店", "N4支店"));
//        shopOptionsMap.put("E銀行", Arrays.asList("E1支店", "E2支店", "E3支店", "E4支店"));
//        shopOptionsMap.put("W銀行", Arrays.asList("W1支店", "W2支店", "W3支店", "W4支店"));
//        shopOptionsMap.put("S銀行", Arrays.asList("S1支店", "S2支店", "S3支店", "S4支店"));
//        model.addAttribute("shopOptionsMap", shopOptionsMap);


        model.addAttribute("nameOptions", nameOptions);
        List<String> SubjectOptions = Arrays.asList("普通", "貯蓄", "当座", "定期");
        model.addAttribute("SubjectOptions", SubjectOptions);
        List<String> BrandOptions = Arrays.asList("PONY", "任天丼", "パナソ肉");
        model.addAttribute("BrandOptions", BrandOptions);
        return "investmentTrustMain";
    }

    @PostMapping("/investmentTrustConfirmation")
    public String confirmation(@ModelAttribute @Validated InvestmentTrustForm investmentTrustForm, Model model) {

        String bankName = investmentTrustForm.getBankName();

        String ShopName = investmentTrustForm.getShopName();

        String Subject = investmentTrustForm.getSubject();

        String bankAccountNum = investmentTrustForm.getBankAccountNum();
        String Purchaser = investmentTrustForm.getPurchaser();
        String BrandName = investmentTrustForm.getBrandName();
        Integer amount = investmentTrustForm.getAmount();
//
//        if(
//                (bankName == null || ShopName == null || Subject == null || bankAccountNum == null
//                        || Purchaser == null || BrandName == null || amount == null )
//                        ||
//                        (bankName.isEmpty() || ShopName.isEmpty() || Subject.isEmpty() || (bankAccountNum.toString()).length() != 7
//                                || Purchaser.isEmpty() || BrandName.isEmpty() || amount <= 0)
//        )
//        {
//            model.addAttribute("investmentTrustApplication", new InvestmentTrustForm());
//            List<String> nameOptions = Arrays.asList("N銀行", "E銀行", "W銀行", "S銀行");
//            model.addAttribute("nameOptions", nameOptions);
//            model.addAttribute("nameOptions", nameOptions);
//            List<String> SubjectOptions = Arrays.asList("普通", "貯蓄", "当座", "定期");
//            model.addAttribute("SubjectOptions", SubjectOptions);
//            List<String> BrandOptions = Arrays.asList("PONY", "任天丼", "パナソ肉");
//            model.addAttribute("BrandOptions", BrandOptions);
//            System.out.println("error");
//            return "investmentTrustMain";
//        }else
//        {
            model.addAttribute("bankName", bankName);
            model.addAttribute("ShopName", ShopName);
            model.addAttribute("Subject", Subject);
            model.addAttribute("bankAccountNum", bankAccountNum);
            model.addAttribute("Purchaser", Purchaser);
            model.addAttribute("BrandName", BrandName);
            model.addAttribute("amount", amount);
            model.addAttribute("investmentTrustApplication", investmentTrustForm);
//            return "investmentTrustConfirmation";
//        }

//        model.addAttribute("bankName", investmentTrustForm.getBankName());
//        model.addAttribute("ShopName", investmentTrustForm.getShopName());
//        model.addAttribute("Subject", investmentTrustForm.getSubject());
//        model.addAttribute("bankAccountNum", investmentTrustForm.getBankAccountNum());
//        model.addAttribute("Purchaser", investmentTrustForm.getPurchaser());
//        model.addAttribute("BrandName", investmentTrustForm.getBrandName());
//        model.addAttribute("amount", investmentTrustForm.getAmount());
//        model.addAttribute("investmentTrustApplication", investmentTrustForm);

        return "investmentTrustConfirmation";
    }

    @PostMapping("/investmentTrustCompletion")
    public String completion(@ModelAttribute InvestmentTrustForm investmentTrustForm, Model model) {
        orderInvestmentTrustService.orderInvestmentTrust(investmentTrustForm);
        return "investmentTrustCompletion";
    }




}

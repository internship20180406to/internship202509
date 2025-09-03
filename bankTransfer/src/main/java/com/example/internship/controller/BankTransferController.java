package com.example.internship.controller;

import com.example.internship.entity.BankTransferForm;
import com.example.internship.service.ApplyBankTransferService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
public class BankTransferController {

    @Autowired
    private ApplyBankTransferService applyBankTransferService;

    @GetMapping("/bankTransfer")
    public String bankTransfer(Model model) {
        String[] bankName = {"", "山陰共同銀行", "海光共同銀行"};
        String[] branchName1 = {"A支店","B支店"};
        String[] branchName2 = {"C支店","D支店"};
        Map<String, String[]> bankBranch = new HashMap<>();
        bankBranch.put("山陰共同銀行", branchName1);
        bankBranch.put("海光共同銀行", branchName2);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMapBankBranch = "abc";
        try {
             jsonMapBankBranch = objectMapper.writeValueAsString(bankBranch);
             model.addAttribute("bankBranch", jsonMapBankBranch);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // ログ出力やエラー処理を行う
        }
        System.out.println(jsonMapBankBranch);

        String[] subjectName = {"普通","定期","当座","貯蓄"};
        model.addAttribute("bankTransferApplication", new BankTransferForm());
        model.addAttribute("nameOptions", bankName);
//        model.addAttribute("branchName1", branchName1);
//        model.addAttribute("branchName2", branchName2);
        model.addAttribute("subjectName", subjectName);
        return "bankTransferMain";
    }

    @PostMapping("/bankTransferConfirmation")
    public String confirmation(@ModelAttribute BankTransferForm bankTransferForm, Model model) {
        //bankTransferForm.setBankName("ながれぼし銀行");
        //model.addAttribute("bankName", bankTransferForm.getBankName());
        //model.addAttribute("bankAccountNum", bankTransferForm.getBankAccountNum());
        model.addAttribute("bankTransferApplication", bankTransferForm);
        return "bankTransferConfirmation";
    }

    @PostMapping("/bankTransferCompletion")
    public String completion(@ModelAttribute BankTransferForm bankTransferForm, Model model) {
        applyBankTransferService.applyBankTransfer(bankTransferForm);
        return "bankTransferCompletion";
    }

}

package com.example.internship.controller;

import com.example.internship.entity.BankTransferForm;
import com.example.internship.service.ApplyBankTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("bankTransferApplication")  // セッション管理開始
public class BankTransferController {

    @Autowired
    private ApplyBankTransferService applyBankTransferService;

    // セッション用フォームの初期化
    @ModelAttribute("bankTransferApplication")
    public BankTransferForm setUpForm() {
        return new BankTransferForm();
    }

    @GetMapping("/bankTransfer")
    public String bankTransfer(Model model) {
        // 選択肢セット
        String[] bankname = {"A銀行", "B銀行", "C銀行", "D銀行"};
        String[] branchname = {"A支店", "B支店"};
        String[] subjectname = {"普通", "定期", "当座", "貯蓄"};

        model.addAttribute("nameOptions", bankname);
        model.addAttribute("nameOptions2", branchname);
        model.addAttribute("nameOptions3", subjectname);

        return "bankTransferMain";  // 入力画面テンプレート
    }

    @PostMapping("/bankTransferConfirmation")
    public String confirmation(@ModelAttribute("bankTransferApplication") BankTransferForm bankTransferForm, Model model) {
        // 選択肢セット
        String[] bankname = {"A銀行", "B銀行", "C銀行", "D銀行"};
        String[] branchname = {"A支店", "B支店"};
        String[] subjectname = {"普通", "定期", "当座", "貯蓄"};

        model.addAttribute("nameOptions", bankname);
        model.addAttribute("nameOptions2", branchname);
        model.addAttribute("nameOptions3", subjectname);

        return "bankTransferConfirmation";  // 確認画面テンプレート
    }

    @PostMapping("/bankTransferBack")
    public String backToInput(@ModelAttribute("bankTransferApplication") BankTransferForm bankTransferForm, Model model) {
        // 選択肢再セット
        String[] bankname = {"A銀行", "B銀行", "C銀行", "D銀行"};
        String[] branchname = {"A支店", "B支店"};
        String[] subjectname = {"普通", "定期", "当座", "貯蓄"};

        model.addAttribute("nameOptions", bankname);
        model.addAttribute("nameOptions2", branchname);
        model.addAttribute("nameOptions3", subjectname);

        return "bankTransferMain";  // 入力画面に戻る
    }

    @PostMapping("/bankTransferCompletion")
    public String completion(@ModelAttribute("bankTransferApplication") BankTransferForm bankTransferForm,
                             SessionStatus sessionStatus) {
        applyBankTransferService.applyBankTransfer(bankTransferForm);

        sessionStatus.setComplete();  // セッションのクリア

        return "bankTransferCompletion";  // 完了画面テンプレート
    }

    // クリアボタン用の処理
    @PostMapping("/bankTransferClear")
    public String clearForm(SessionStatus sessionStatus, Model model) {
        // セッションのクリア
        sessionStatus.setComplete();

        // 新しい空フォームをセット
        model.addAttribute("bankTransferApplication", new BankTransferForm());

        // 選択肢再セット
        String[] bankname = {"A銀行", "B銀行", "C銀行", "D銀行"};
        String[] branchname = {"A支店", "B支店"};
        String[] subjectname = {"普通", "定期", "当座", "貯蓄"};

        model.addAttribute("nameOptions", bankname);
        model.addAttribute("nameOptions2", branchname);
        model.addAttribute("nameOptions3", subjectname);

        return "bankTransferMain";  // 入力画面に戻る（空フォーム）
    }
}


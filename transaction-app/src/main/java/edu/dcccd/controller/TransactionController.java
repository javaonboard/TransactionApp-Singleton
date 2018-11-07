package edu.dcccd.controller;

import edu.dcccd.entity.Transaction;
import edu.dcccd.repository.SingletonTransaction;
import edu.dcccd.services.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TransactionController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    TransactionServiceImpl transactionService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName",appName);
        return "home";
    }

    @GetMapping("/transaction")
    public String loadTransactionPage(Model model){
        List<Transaction> transactions = transactionService.getAllTransaction();
        model.addAttribute("transactionForm", new Transaction());
        model.addAttribute("days",getDays());
        model.addAttribute("transactions", transactions);
        return "transaction";
    }

    @PostMapping(value="/create")
    public String createTransaction(@ModelAttribute("transactionForm") Transaction transaction){
        transaction.setId(SingletonTransaction.getInstance().autoIncrementID+=1);
        transactionService.createTransaction(transaction);
        return "redirect:transaction";
    }

    public List<String> getDays(){
        List<String> days = new ArrayList<>();
        Arrays.asList(DayOfWeek.values()).stream()
                .forEach(day->days.add(day.toString()));
        return days;
    }
}

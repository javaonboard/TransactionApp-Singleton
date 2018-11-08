package edu.dcccd.lesson11.controller;

import edu.dcccd.lesson11.model.SelectedDay;
import edu.dcccd.lesson11.model.Transaction;
import edu.dcccd.lesson11.services.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ReportController {

    @Autowired
    TransactionServiceImpl transactionService;

    @GetMapping(value = "/report")
    public String createReport(Model model) {
        SelectedDay selectedDays = new SelectedDay();
        model.addAttribute("days", getDays());
        model.addAttribute("selected", selectedDays);
        return "report";
    }

    @PostMapping(value = "/getReport")
    public String calculate(@ModelAttribute("selected") SelectedDay selected, Model model) {
        List<Transaction> selectedTransaction = transactionService.getTransactionByDay(selected);
        model.addAttribute("transactions", selectedTransaction);
        model.addAttribute("days", getDays());
        return ("report");
    }

    public List<String> getDays() {
        return Arrays.asList(DayOfWeek.values()).stream().map(s -> s.toString()).collect(Collectors.toList());
    }

}

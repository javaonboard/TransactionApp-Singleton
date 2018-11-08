package edu.dcccd.lesson11.services;

import edu.dcccd.lesson11.model.SelectedDay;
import edu.dcccd.lesson11.model.Transaction;

import java.util.List;

public interface TransactionService {
    void createTransaction(Transaction transaction);

    List<Transaction> getAllTransaction();

    List<Transaction> getTransactionByDay(SelectedDay selected);
}

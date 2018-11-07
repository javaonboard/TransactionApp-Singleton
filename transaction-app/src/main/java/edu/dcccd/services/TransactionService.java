package edu.dcccd.services;

import edu.dcccd.model.Transaction;

import java.util.List;

public interface TransactionService
{
    void createTransaction(Transaction transaction);
    List<Transaction> getAllTransaction();
}

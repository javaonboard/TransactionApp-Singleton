package edu.dcccd.services;

import edu.dcccd.model.Transaction;
import edu.dcccd.repository.SingletonTransaction;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService
{
    @Override
    public void createTransaction(Transaction transaction)
    {
        SingletonTransaction.getInstance().transactions.add(transaction);
    }

    @Override
    public List<Transaction> getAllTransaction()
    {
        return SingletonTransaction.getInstance().transactions;
    }
}

package edu.dcccd.repository;

import edu.dcccd.model.Transaction;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SingletonTransaction
{

    private static SingletonTransaction instance = null;

    public List<Transaction> transactions;
    public Long autoIncrementID = 1002L;

    private SingletonTransaction()
    {
        transactions = new ArrayList<>();
        Transaction tr01 = new Transaction(1001L,"REVENUE","SUNDAY", BigDecimal.valueOf(12.00),"Some Description");
        Transaction tr02 = new Transaction(1002L,"EXPENSE","MONDAY", BigDecimal.valueOf(12.00),"Some Description");
        transactions.add(tr01);transactions.add(tr02);
    }

    public static SingletonTransaction getInstance()
    {
        if(instance == null){
            instance = new SingletonTransaction();
        }
        return instance;
    }
}

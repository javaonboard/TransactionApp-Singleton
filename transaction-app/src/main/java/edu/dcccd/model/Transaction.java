package edu.dcccd.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
public class Transaction
{

    private Long id;
    private String day;
    private String time;
    private String description;
    private BigDecimal amount;
    private String type;

    public Transaction()
    {
        this.time = currentTime();
    }

    public Transaction(Long id, String type,String day, BigDecimal amount, String description)
    {
        this.time = currentTime();
        this.id=id;
        this.day = day;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    private static String currentTime()
    {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
    }
}

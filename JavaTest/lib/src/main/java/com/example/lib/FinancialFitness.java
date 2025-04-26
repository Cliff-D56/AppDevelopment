package com.example.lib;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FinancialFitness {
    public static void main(String[] args) {
        double income = 2876.70;
        double bills = 2224.62;
        double moneyLeftOver = income-bills;
        int daysInCurrentMonth = LocalDate.now().lengthOfMonth();
        LocalDateTime myDate = LocalDateTime.now();
        LocalDateTime offset = LocalDateTime.now().withDayOfMonth(daysInCurrentMonth);
        int daysRemaining = daysInCurrentMonth - myDate.getDayOfMonth();
        double moneyPerDay = Math.round(moneyLeftOver/daysRemaining*100)/100.0;
        System.out.println(moneyLeftOver);
        System.out.println(myDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println(moneyPerDay);
        System.out.println(offset.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }
}

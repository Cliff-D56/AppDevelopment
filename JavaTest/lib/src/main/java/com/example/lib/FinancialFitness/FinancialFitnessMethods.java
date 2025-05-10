package com.example.lib.FinancialFitness;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FinancialFitnessMethods {
    public static void results(float income,float goal,float moneySpent,float bills){
        int daysInCurrentMonth = LocalDate.now().lengthOfMonth();
        LocalDateTime myDate = LocalDateTime.now();
        LocalDateTime offset = LocalDateTime.now().withDayOfMonth(daysInCurrentMonth);
        int daysRemaining = daysInCurrentMonth - myDate.getDayOfMonth()+1;
        float moneyRemaining = (income-bills)-(goal+moneySpent);
        float moneyPerDay = Math.round(moneyRemaining/daysRemaining*100)/100.0F;
//            System.out.println(moneyLeftOver);
        System.out.println(myDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        String msg = moneyRemaining < 0 ?"You've Exceeded your spending and are behind $"+moneyRemaining:
                "I can spend $"+moneyPerDay+" per day for the next "+daysRemaining+" days to save $"+goal+" this month%n";
        System.out.println(msg );
        System.out.println(offset.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }
    public static float showAllPayments(List<String> payments){
//        payments.sort(Comparator.naturalOrder());
        float total = 0.0F;
        for(String payment : payments) {
            String[] split = payment.split(":");
            total += Float.parseFloat(split[2]);
            System.out.printf("%s | %-15s| $%-15s |%n",split[0],split[1],split[2]);
        }
        System.out.printf("I've spent %s over the course of this month%n",total);
        return total;
    }
    public static float allBills(List<String> bills){
        float total = 0F;
        for(String bill:bills){
            String[] split = bill.split(":");
            total += Float.parseFloat(split[2]);
        }
        return total;
    }
    public static float incomePayments(List<String> incomes){
        float total = 0.0F;
        for(String income : incomes) {
            String[] split = income.split(":");
            total += Float.parseFloat(split[2]);
            System.out.printf("%s | %-15s| $%-15s |%n",split[0],split[1],split[2]);
        }
        System.out.printf("I've earned %s over the course of this month%n",total);
        return total;
    }
    public static void addSpending(List<String>payments, Path file, Scanner input) throws IOException {
        ArrayList<String> allPayments = new ArrayList<>();
        System.out.println("Type in where the payment was");
        String paymentName = input.nextLine();
        System.out.println("Type how much the payment was");
        float paymentAmount =  Float.parseFloat(input.nextLine());
        String newEntry  = payments.size()+1+":"+paymentName+":"+paymentAmount;
        payments.add(newEntry);
        Files.write(file,payments);
    }
}

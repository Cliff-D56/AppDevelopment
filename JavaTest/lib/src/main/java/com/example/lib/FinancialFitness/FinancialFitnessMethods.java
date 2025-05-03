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
    public static void results(double income,double goal,double moneySpent){
        int daysInCurrentMonth = LocalDate.now().lengthOfMonth();
        LocalDateTime myDate = LocalDateTime.now();
        LocalDateTime offset = LocalDateTime.now().withDayOfMonth(daysInCurrentMonth);
        int daysRemaining = daysInCurrentMonth - myDate.getDayOfMonth()+1;
        double moneyRemaining = income-(goal+moneySpent);
        double moneyPerDay = Math.round(moneyRemaining/daysRemaining*100)/100.0;
//            System.out.println(moneyLeftOver);
        System.out.println(myDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.printf("I can spend $%s per day for the next %s days to save $%s this month%n",moneyPerDay,daysRemaining,goal);
        System.out.println(offset.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }
    public static Double showAllPayments(List<String> payments){
//        payments.sort(Comparator.naturalOrder());
        double total = 0.0;
        for(String payment : payments) {
            String[] split = payment.split(":");
            total += Double.parseDouble(split[2]);
            System.out.printf("%s | %-15s| $%-15s |%n",split[0],split[1],split[2]);
        }
        System.out.printf("I've spent %s over the course of this month%n",total);
        return total;
    }
    public static Double incomePayments(List<String> incomes){
        double total = 0.0;
        for(String income : incomes) {
            String[] split = income.split(":");
            total += Double.parseDouble(split[2]);
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
        double paymentAmount =  Double.parseDouble(input.nextLine());
        String newEntry  = payments.size()+1+":"+paymentName+":"+paymentAmount;
        payments.add(newEntry);
        Files.write(file,payments);
    }
}

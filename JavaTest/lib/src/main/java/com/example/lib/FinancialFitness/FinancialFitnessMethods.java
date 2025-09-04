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
    public static float results(float income, float goal, float moneySpent, float bills) {
        int daysInCurrentMonth = LocalDate.now().lengthOfMonth();
        LocalDateTime myDate = LocalDateTime.now();
        LocalDateTime offset = LocalDateTime.now().withDayOfMonth(daysInCurrentMonth);
        int daysRemaining = daysInCurrentMonth - myDate.getDayOfMonth() + 1;
        float moneyRemaining = (income - bills) - (goal + moneySpent);
        float moneySaved = (income-bills) - moneySpent;
        float moneyPerDay = Math.round(moneyRemaining / daysRemaining * 100) / 100.0F;
//            System.out.println(moneyLeftOver);
        String msg = moneyRemaining < 0 ? "You've Exceeded your spending and are behind $" + (moneyRemaining*-1)+" to meet your goal of $"+goal + "\nAs of now you're profit for this month is $"+(moneyRemaining+goal):
                "I can spend $" + moneyPerDay + " per day for the next " + daysRemaining + " days to save $" + goal + " this month";
        System.out.println(msg);
        System.out.println(offset.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        if(moneyRemaining >0){
            System.out.printf("I've saved $%s so far and can only spend $%s as of now%n",moneySaved,moneySaved-goal);
        }
        return moneyPerDay;
    }

    public static float initResults(float income, float goal, float bills) {
        int daysInCurrentMonth = LocalDate.now().lengthOfMonth();
        LocalDateTime startDate = LocalDateTime.now().withDayOfMonth(1);
        LocalDateTime offset = LocalDateTime.now().withDayOfMonth(daysInCurrentMonth);
        float moneyRemaining = (income - bills) - (goal);
        float moneyPerDay = Math.round(moneyRemaining / daysInCurrentMonth * 100) / 100.0F;
//            System.out.println(moneyLeftOver);
        String msg = moneyRemaining < 0 ? "You've Exceeded your spending and are behind $" + moneyRemaining :
                "I can spend $" + moneyPerDay + " per day for the next " + daysInCurrentMonth + " days to save $" + goal + " this month";
//        System.out.println(msg);
//        System.out.println(offset.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        return moneyPerDay;
    }

    public static float showAllPayments(List<String> payments) {
//        payments.sort(Comparator.naturalOrder());
        float total = 0.0F;
        for (String payment : payments) {
            String[] split = payment.split(":");
//            if(Float.parseFloat(split[2])>1000){
//                split[2] = String.valueOf(Float.parseFloat(split[2])/6);
//            }
            total += Float.parseFloat(split[2]);
            System.out.printf("%-4s | %-20s| $%-6s |%n", split[0], split[1], split[2]);
        }
        System.out.printf("%nI've spent $%s over the course of this month%n", total);
        return total;
    }

    public static float allBills(List<String> bills) {
        float total = 0F;
        for (String bill : bills) {
            String[] split = bill.split(":");
            total += Float.parseFloat(split[2]);
        }
        System.out.printf("I pay $%s a month in Bills%n",total);
        return total;
    }

    public static float addPayments(List<String> AddPayments) {
        float total = 0f;
        for (String income : AddPayments) {
            String[] split = income.split(":");
            total += Float.parseFloat(split[2]);
            System.out.printf("%-4s | %-15s| $%-6s |%n", split[0], split[1], split[2]);
        }
        System.out.println("--------------------------------------");
        return total;
    }

    public static float incomePayments(List<String> incomes, List<String> AddPayments) {
        float total = 0.0F;
        for (String income : incomes) {
            String[] split = income.split(":");
            total += Float.parseFloat(split[2]);
            System.out.printf("%s | %-15s| $%-8s |%n", split[0], split[1], split[2]);
        }
        for (String income : AddPayments) {
            String[] split = income.split(":");
            total += Float.parseFloat(split[2]);
        }
        System.out.printf("%nI've earned %s over the course of this month%n%n", total);
        return total;
    }

    public static void addSpending(List<String> payments, Path file, Scanner input) throws IOException {
        ArrayList<String> allPayments = new ArrayList<>();
        System.out.println("Type in where the payment was");
        String paymentName = input.nextLine();
        System.out.println("Type how much the payment was");
        float paymentAmount = Float.parseFloat(input.nextLine());
        String newEntry = payments.size() + 1 + ":" + paymentName + ":" + paymentAmount;
        payments.add(newEntry);
        Files.write(file, payments);
    }

    public static void calendar(Path file, List<String> days, float budget, float goal) throws IOException {
        ArrayList<ArrayList> calendar = new ArrayList<>();
        LocalDateTime myDate = LocalDateTime.now();
        int daysInCurrentMonth = LocalDate.now().lengthOfMonth();
        ArrayList<String> temp = new ArrayList<>();
        String msg = budget < 0 ? "You've Exceeded your spending and are behind $" + budget :
                "I can spend $" + budget + " per day to save $" + goal + " this month";
        float total = 0;
        for (int i = 1; i <= daysInCurrentMonth; i++) {
            myDate = LocalDateTime.now().withDayOfMonth(i);
            int day = myDate.getDayOfMonth();
            String month = myDate.getMonth().toString();
            total += budget;
            if (i == 1) {
                temp.add("Initial Calendar\n"+day + " -");
            }
            if (myDate.getDayOfWeek().toString().equals("SATURDAY")) {
//                    temp.add(LocalDateTime.now().withDayOfMonth(i).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))+" "+myDate.getDayOfWeek());
                temp.add(day + " " + month + " Budget for the week is $" + total);
                calendar.add(temp);
                String line = String.join(" ", temp);
                days.add(line);
                if (i == daysInCurrentMonth) {
                    days.add(msg);
                }
                Files.write(file, days);
                total = 0;
                temp = new ArrayList<>();
                continue;
            }
            if (myDate.getDayOfWeek().toString().equals("SUNDAY") && i != 1) {
                temp.add(day + " -");
            }
            if (i == daysInCurrentMonth) {
                temp.add(day + " " + month + " Budget for the week is $" + total);
                String line = String.join(" ", temp);
                days.add(line);
                days.add(msg);
            }
            Files.write(file, days);
//                temp.add(LocalDateTime.now().withDayOfMonth(i).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))+" "+myDate.getDayOfWeek());
//                calendar.add(LocalDateTime.now().withDayOfMonth(i).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))+" "+myDate.getDayOfWeek());
//            System.out.printf("%s %s%n",LocalDateTime.now().withDayOfMonth(i).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)),myDate.getDayOfWeek());
        }

//        System.out.println(calendar);
//
//
//        System.out.println(myDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
    }
}

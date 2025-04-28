package com.example.lib.FinancialFitness;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.*;

public class FinancialFitness extends FinancialFitnessMethods {
    public String item;
    public String amount;
    public FinancialFitness(String item,String amount){
        this.item = item;
        this.amount = amount;
    }
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String paymentfile = "Spending.txt";
        String dir = "lib/src/main/java/com/example/lib/FinancialFitness";
        Path file = Paths.get(dir,paymentfile);
        try{
            List<String> paymentList = Files.readAllLines(file);
            double income = 2876.70;
            double goal = 200.00;
            double moneySpent = showAll(paymentList);
            int daysInCurrentMonth = LocalDate.now().lengthOfMonth();
            LocalDateTime myDate = LocalDateTime.now();
            LocalDateTime offset = LocalDateTime.now().withDayOfMonth(daysInCurrentMonth);
            int daysRemaining = daysInCurrentMonth - myDate.getDayOfMonth()+1;
            double moneyRemaining = income-goal-moneySpent;
            double moneyPerDay = Math.round(moneyRemaining/daysRemaining*100)/100.0;
//            System.out.println(moneyLeftOver);
            System.out.println(myDate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
            System.out.printf("I can spend $%s per day for the next %s days to save $%s this month%n",moneyPerDay,daysRemaining,goal);
            System.out.println(offset.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        }catch(IOException e){
            System.out.println(file);
            System.out.println(System.getProperty("user.dir"));
            e.printStackTrace();
        }



        double income = 2876.70;
        double bills = 2224.62;

    }
}

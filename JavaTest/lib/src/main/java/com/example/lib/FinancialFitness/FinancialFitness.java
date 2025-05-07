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
        String incomeFile = "Income.txt";
        String billFile = "Bills.txt";
        String dir = "lib/src/main/java/com/example/lib/FinancialFitness/Spending";
        Path Spending = Paths.get(dir,paymentfile);
        Path Income = Paths.get(dir,incomeFile);
        Path Bills = Paths.get(dir,billFile);
        try{
            List<String> paymentList = Files.readAllLines(Spending);
            List<String> incomeList = Files.readAllLines(Income);
            List<String> allbills = Files.readAllLines(Bills);
            double bills = allBills(allbills);
            double income = incomePayments(incomeList);
            double moneySpent = showAllPayments(paymentList);
            double goal = 500.00;
            results(income,goal,moneySpent,bills);
//            System.out.println(showAllPayments(paymentList));
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(System.getProperty("user.dir"));
    }
}

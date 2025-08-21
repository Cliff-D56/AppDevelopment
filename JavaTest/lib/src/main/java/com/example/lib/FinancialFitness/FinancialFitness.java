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
        String calendarFile = "Calendar.txt";
        String addIncome = "AdditionalPayments.txt";
        String dir = "lib/src/main/java/com/example/lib/FinancialFitness/Spending";
        Path Spending = Paths.get(dir,paymentfile);
        Path Income = Paths.get(dir,incomeFile);
        Path Bills = Paths.get(dir,billFile);
        Path Calendar = Paths.get(dir,calendarFile);
        Path AddPayments = Paths.get(dir,addIncome);
        Files.deleteIfExists(Calendar);
        Files.createFile(Calendar);
        try{
            List<String> paymentList = Files.readAllLines(Spending);
            List<String> incomeList = Files.readAllLines(Income);
            List<String> allbills = Files.readAllLines(Bills);
            List<String> calendarDays = Files.readAllLines(Calendar);
            List<String> addPayments = Files.readAllLines(AddPayments);
            float bills = allBills(allbills);
            float addpayments = addPayments(addPayments);
            float income = incomePayments(incomeList,addPayments);
            float moneySpent = showAllPayments(paymentList);
            float goal = 500;//income/10;
            float initGoal = 500;//(income-addpayments)/10;
            float budget = results(income,goal,moneySpent,bills);
            float initBudget = initResults((income-addpayments),initGoal,bills);
            calendar(Calendar,calendarDays,initBudget,initGoal);
            //  System.out.println(showAllPayments(paymentList));
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(System.getProperty("user.dir"));
    }
}

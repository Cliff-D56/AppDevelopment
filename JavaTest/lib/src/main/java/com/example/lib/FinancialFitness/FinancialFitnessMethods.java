package com.example.lib.FinancialFitness;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FinancialFitnessMethods {
    public static Double showAll(List<String> payments){
        payments.sort(Comparator.naturalOrder());
        double total = 0.0;
        for(String payment : payments) {
            String[] split = payment.split(":");
            total += Double.parseDouble(split[2]);
            System.out.printf("%s |%-15s| $%-15s |%n",split[0],split[1],split[2]);
        }
        System.out.printf("I've spent %s over the course of this month%n",total);
        return total;
    }
    public static void addSpending(List<String>payments, Paths file, Scanner input) {
        ArrayList<String> allPayments = new ArrayList<>();
        System.out.println("Type in where the payment was");
        String paymentName = input.nextLine();
    }
}

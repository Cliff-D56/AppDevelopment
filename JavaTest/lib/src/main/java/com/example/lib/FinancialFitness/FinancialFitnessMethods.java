package com.example.lib.FinancialFitness;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FinancialFitnessMethods {
    public static Double showAll(List<String> payments){
        payments.sort(Comparator.naturalOrder());
        Double total = 0.0;
        ArrayList<Double> allPayments = new ArrayList<>();
        for(String payment : payments) {
            String[] split = payment.split(" : ");
            total += Double.parseDouble(split[1]);
            System.out.printf("%-15s| $ %-15s |%n", split[0], split[1]);
            FinancialFitness newpayment = new FinancialFitness(split[0], split[1]);
        }
        System.out.printf("I've spent %s over the course of this month%n",total);
        return total;
    }
}

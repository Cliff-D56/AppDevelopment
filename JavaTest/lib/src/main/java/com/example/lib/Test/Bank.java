package com.example.lib.Test;

public class Bank{
    public String name;
    public float interestRate;
    public void giveInfo(){
        System.out.println(name);
        System.out.println(interestRate);
    }
    public Bank(String name,float interestRate){
        this.name = name;
        this.interestRate = interestRate;
    }
}

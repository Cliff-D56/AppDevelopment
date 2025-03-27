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
abstract class Banks{
    abstract float getInterestRate();
}

class TestBanks{
    static class SBI extends Banks{
        @Override
        float getInterestRate() {
            return .07F;
        }
        public static void main(String[] args) {
            Banks Bank1 = new SBI();
            System.out.println(Bank1.getInterestRate());
        }
    }
    static class PNB extends Banks{
        @Override
        float getInterestRate() {
            return .05F;
        }
        public static void main(String[] args) {
            Banks Bank1 = new PNB();
            System.out.println(Bank1.getInterestRate());
        }
    }

}
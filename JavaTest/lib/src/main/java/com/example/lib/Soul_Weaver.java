package com.example.lib;

public class Soul_Weaver {
    String name;
    int age;
    private Boolean deadOrAlive;
    public void sayHello(){
        System.out.println("Hello");
    }
    public Boolean getDOA(){
        return deadOrAlive;
    }
    public void setDeadOrAlive(Boolean bool){
        this.deadOrAlive = bool;
    }
}

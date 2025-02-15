package com.example.lib.Soul_Weavers;

public class Soul_Weaver {
    private String name;
    private int age;
    private Boolean deadOrAlive;

    public Soul_Weaver(){}
    public Soul_Weaver(String name,int age,Boolean deadOrAlive){
        this.name = name;
        this.age = age;
        this.deadOrAlive = deadOrAlive;
    }
    public void sayHello(){
        System.out.println("Hello");
    }
    public Boolean getDOA(){
        return deadOrAlive;
    }
    public void setDeadOrAlive(Boolean bool){
        this.deadOrAlive = bool;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
}

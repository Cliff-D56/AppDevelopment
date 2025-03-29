package com.example.lib.Soul_Weavers;

public class Soul_Weaver {
    static private String name;
    static private int age;
    static private Boolean deadOrAlive;

    public Soul_Weaver(){}
    public Soul_Weaver(String name,int age,Boolean deadOrAlive){
        Soul_Weaver.name = name;
        Soul_Weaver.age = age;
        Soul_Weaver.deadOrAlive = deadOrAlive;
    }
    public void sayHello(){
        System.out.println("Hello");
    }
    public Boolean getDOA(){
        return deadOrAlive;
    }
    public void setDeadOrAlive(Boolean bool){
        Soul_Weaver.deadOrAlive = bool;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        Soul_Weaver.name = name;
    }
    public void setAge(int age){
        Soul_Weaver.age = age;
    }
}

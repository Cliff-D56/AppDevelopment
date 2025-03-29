package com.example.lib.Soul_Weavers;

public class Wrath extends Soul_Weaver {
    public Wrath(String name, int age, Boolean deadOrAlive) {
        super(name, age, deadOrAlive);
    }
    public Wrath(){}

    public void sayHello(){
        System.out.printf("Im %s%n",getName());
    }
}

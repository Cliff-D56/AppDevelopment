package com.example.lib;

import com.example.lib.Soul_Weavers.Pride;
import com.example.lib.Soul_Weavers.Soul_Weaver;
import com.example.lib.Soul_Weavers.Wrath;
import com.example.lib.Test.Bank;
import com.example.lib.Test.Encap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class MyClass{
    // TO WRITE COMMENTS USE THE // OR /* */
    public static Boolean check(Soul_Weaver Sin){
        Sin.sayHello();
        return (Sin instanceof Wrath);
    }
    public static int triple(int num){
        return num *3;
    }
    // MAIN METHOD SYNTAX USED TO RUN JAVA CODE
    public static void main(String[] args){
        // TO PRINT TO CONSOLE USE System.out.println();
        System.out.println("This is how to talk to console");

        // TO STORE VALUES IN WORDS USE VARIABLES
        int variable = 2;
        /*
        THERE ARE 8 DIFFERENT TYPES OF PRIMITIVE VARIABLES FOR JAVA

        BYTE: NUMBERS BETWEEN -128 TO 127
        SHORT: NUMBERS BETWEEN -32768 TO 32767
        INT: NUMBERS BETWEEN -2BILLION TO 2BILLION
        LONG: NUMBERS EXPONENTIALLY BIGGER THAN BILLION (REQUIRES AN "L" AT THE END OF NUMBER)

        FLOAT: NUMBERS WITH DECIMALS UP TO 7 (REQUIRES AN "F" AT THE END OF NUMBER)
        DOUBLES: NUMBERS WITH DECIMALS UP TO 16

        CHAR: LETTERS OR SYMBOLS (CAN ALSO PUT TEXT OPTIONS SUCH AS \n for new line and \t for tab)

        BOOLEANS: TRUE OR FALSE VALUES

        THERE ARE SEVERAL NON-PRIMITIVE DATA TYPES THAT INCLUDE OBJECTS

        ARRAYS: STORES MULTIPLE SAME TYPE OF VALUES IN A SINGLE OBJECT
        STRINGS: A STRING OF CHARS LIKE CREATING A SENTENCE
        CLASS: BASICALLY A BLUEPRINT FOR CREATING OBJECTS
         */

        //VALUES CAN BE CHANGED FROM ONE VARIABLE DATA TYPE TO ANOTHER,
        //THIS IS CALLED TYPE CASTING AND THERE ARE TWO TYPES

        // IMPLICIT TYPE CASTING:
        int numInt = 2;
        double numDouble = numInt; // 2.0

        // EXPLICIT TYPE CASTING:
        double pi = 3.14;
        int numPi = (int)pi; // 3
        // *NOTE* pi loses .14 since it was converted into an integer and had no space for decimals

        // TYPE CASTING TO VASTLY DIFFERENT DATA TYPES:
        char myChar = (char)(numInt + 'A'); // C
        // FIRST THE INT IS ADDED TO THE ASCII VALUE OF A(65) SO THE INSIDE WILL HAVE A VALUE OF 67
        // THEN THAT VALUE WILL BE CONVERTED INTO THE ASCII TABLE AND WILL ASSIGN THAT CHAR VALUE TO THE VARIABLE

        /*
        THERE ARE OPERATORS THAT PERFORM FUNCTIONS USING SYMBOLS

        ARITHMETIC

        +: ADDS VALUES TOGETHER
        -: SUBTRACTS VALUES
        /: DIVIDE VALUES
        //: DIVIDE VALUES BUT STOPS AT NEAREST WHOLE NUMBER
        *: MULTIPLIES VALUES
        %: DIVIDES VALUES AND GIVES REMAINDERS

        COMPARISON (RETURNS TRUE OR FALSE)

        ==: CHECKS EQUAL VALUES
        ===: CHECKS EXACT VALUES
        !=: CHECKS VALUES AREN'T THE SAME
        <: CHECKS VALUES ARE SMALLER
        <: CHECKS VALUES ARE SMALLER OR EQUAL TO
        >: CHECKS VALUES ARE BIGGER
        >: CHECKS VALUES ARE BIGGER OR EQUAL

        LOGICAL

        &&: AND (BOTH NEED TO BE TRUE OR RETURNS FALSE)
        ||: OR (ONE NEEDS TO BE TRUE TO RETURN TRUE)
        !: NOT (REVERSES ANY BOOLEAN VALUE)
         */
        Soul_Weaver Edward = new Wrath();
        Pride Shahbaz = new Pride("Pride the Arrogant",92,true);
        Shahbaz.sayHello();
        Edward.setAge(27);
        Edward.setName("Wrath the Furious");
        Edward.setDeadOrAlive(true);
        Edward.sayHello();
        String [] names = {"Clifford"};
        ArrayList<String> Names = new ArrayList<>();
        Names.add("Clifford");
        Names.add("Anna");
        Names.add("Edward");
//        Bank SBI = new Bank("SBI",.08F);
//        Bank ICICI = new Bank("ICICI",.07F);
//        Bank AXIS = new Bank("AXIS",.09F);
//
//        SBI.giveInfo();
//        ICICI.giveInfo();
//        AXIS.giveInfo();
        try(Connection conn = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/MySQL80","root","Anna3256")){
            PreparedStatement ps = conn.prepareStatement("Insert into Checks (name,age) Values (?,?)");
            ps.setString(1,"Aryelle");
            ps.setInt(2,1);
            int rows = ps.executeUpdate();
            System.out.println(rows);
        } catch(SQLException e){
          e.printStackTrace();
        }
        String [] arr = {"7","3","5","1","2","3"};
        Arrays.sort(arr, (num1, num2) -> Integer.parseInt(num2)-Integer.parseInt(num1));
        System.out.println(Arrays.toString(arr));
        Function<String,String> computation = String::toUpperCase;
        System.out.println(computation.apply("clifford"));
    }
}
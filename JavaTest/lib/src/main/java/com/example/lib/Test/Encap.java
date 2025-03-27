package com.example.lib.Test;

public class Encap {
    class Student{
        Student(){};
        protected int ID =2;
        public String studentName = "Clifford";
        String collegeName = "SFA";
        private String address ="123";
        Student(int Id, String studentName, String address, String collegeName){
            this.ID = Id;
            this.studentName = studentName;
            this.address = address;
            this.collegeName = collegeName;
        }
    }

}

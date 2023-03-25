package com.example.myapplication;

public class Student {
    private int Id;
    private String Name;
    private int Year;
    private String Address;

    public Student(int id, String name, int Year, String address) {
        Id = id;
        Name = name;
        this.Year = Year;
        Address = address;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}

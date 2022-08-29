package com.demo.hometask.objects;

import java.util.ArrayList;

public class Details {
    // Creating an object of ArrayList
    public static ArrayList<Details> Data = new ArrayList<Details>();
    public int number;
    public String name;
    public Details(int number, String name)
    {
        // This keyword refers
        // to parent instance itself
        this.number = number;
        this.name = name;
    }
}

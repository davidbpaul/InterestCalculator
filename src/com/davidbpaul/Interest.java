package com.davidbpaul;

/**
 * Created by davidpaul on 2017-03-18.
 */
public class Interest {
    private int id;
    private String name;
    private double interest;
    private double rate;
    private int years;

    public Interest(int id, String name, double interest, double rate, int years) {
        this.id = id;
        this.name = name;
        this.interest = interest;
        this.rate = rate;
        this.years = years;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getInterest() {
        return interest;
    }

    public double getRate() {
        return rate;
    }

    public int getYears() {
        return years;
    }
    public static Interest createItem(int id, String name, double interest, double rate, int years){
        return new Interest(id, name, interest, rate, years);
    }
}

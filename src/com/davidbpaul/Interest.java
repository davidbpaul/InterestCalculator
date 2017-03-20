package com.davidbpaul;

/**
 * Created by davidpaul on 2017-03-18.
 */
public class Interest {
    private String name;
    private double interest;
    private double rate;
    private int years;

    public Interest(String name, double interest, double rate, int years) {
        this.name = name;
        this.interest = interest;
        this.rate = rate;
        this.years = years;
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
    public static Interest createItem(String name, double interest, double rate, int years){
        return new Interest(name, interest, rate, years);
    }

}

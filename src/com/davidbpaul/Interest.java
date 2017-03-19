package com.davidbpaul;

import java.text.DecimalFormat;

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

    //	calculates investment. returns array of data(type double)
    private double[] calculate(double investment, double rate, int years) {
//		year+1  to start to count year of investment
        double[] array = new double[years+1];
        for(int i=0;i<array.length;i++){
            if(i == 0){
                array[i] = investment;
            }else{
                array[i] = investment += (investment * (rate / 100));
            }
        }
        return array;
    }
    //	print table including years and balance in console
    private void printArray(String name,double investment, double rate, int years, double[] array) {
        DecimalFormat two = new DecimalFormat("##0.00");
        DecimalFormat zero = new DecimalFormat("##0");
        System.out.println(name +"'s Investment Results ($" + zero.format(investment) + " %" + zero.format(rate) + " over " + zero.format(years) + " years)");
        System.out.println("YEAR	" + "BALANCE");
        for(int i=0; i<array.length; i++) {
            System.out.println(i + "	" + "$" + two.format(array[i]));
        }
    }
}

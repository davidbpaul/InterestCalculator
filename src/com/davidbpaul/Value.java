package com.davidbpaul;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by davidpaul on 2017-03-18.
 */


public class Value {
    private String myName;
    private double myInterest;
    private double myRate;
    private int myYears;
    private ArrayList<Interest> myItems;


    public Value(String myName, double myInterest, double myRate, int myYears) {
        this.myName = myName;
        this.myInterest = myInterest;
        this.myRate = myRate;
        this.myYears = myYears;
        this.myItems = new ArrayList<Interest>();
    }

    public boolean addNewItem(Interest item){
        if(findItem(item.getName()) >=0){
            System.out.println("Contact is already on file");
            return false;
        }
        myItems.add(item);
        return true;
    }

    private int findItem(Interest searchItem){
        return this.myItems.indexOf(searchItem);
    }
    private int findItem(String searchItem){
        for(int i=0; i<this.myItems.size(); i++){
            Interest item = this.myItems.get(i);
            if(item.getName().equals(searchItem)){
                return i;
            }
        }
        return -1;

    }
//    public void expand(searchItem) {
//
//        String name = this.myItems.get(i).getName();
//        double interest =  this.myItems.get(i).getInterest();
//        double rate = this.myItems.get(i).getRate();
//        int year = this.myItems.get(i).getYears();
//
//    }
    public boolean updateItem(Interest oldItem, Interest newItem){
        int foundPosition = findItem(oldItem);
        if(foundPosition < 0){
            System.out.println(oldItem.getName() + " , was not found.");
            return false;
        }
        this.myItems.set(foundPosition, newItem);
        System.out.println(oldItem.getName() + " , was replaced with " + newItem.getName());
        return true;
    }

    public boolean removeContact(Interest item){
        int foundPosition = findItem(item);
        if(foundPosition <0){
            System.out.println(item.getName() + ", was not found.");
            return false;
        }
        this.myItems.remove(foundPosition);
        System.out.println(item.getName() + ", was deleted.");
        return true;

    }
    public String queryItem(Interest item){
        if(findItem(item) >=0){
            return item.getName();
        }
        return null;
    }
    public Interest queryItem(String name){
        int position = findItem(name);
        if(position >= 0){
            return this.myItems.get(position);
        }
        return null;
    }
    public void printItems(){
        DecimalFormat zero = new DecimalFormat("##0");
        for(int i=0;i<this.myItems.size(); i++){

            String name = this.myItems.get(i).getName();
            double interest =  this.myItems.get(i).getInterest();
            double rate = this.myItems.get(i).getRate();
            int year = this.myItems.get(i).getYears();

            System.out.println(name + " -> "
                    + name + "'s Investment Results ($" + zero.format(interest)+
                    " %" + zero.format(rate) + " over " + year + " years)");

        }
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

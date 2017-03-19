package com.davidbpaul;

import java.util.ArrayList;

/**
 * Created by davidpaul on 2017-03-18.
 */


public class Value {
    private int myId;
    private String myName;
    private double myInterest;
    private double myRate;
    private int myYears;
    private ArrayList<Interest> myItems;


    public Value(int myId, String myName, double myInterest, double myRate, int myYears) {
        this.myId = myId;
        this.myName = myName;
        this.myInterest = myInterest;
        this.myRate = myRate;
        this.myYears = myYears;
        this.myItems = new ArrayList<Interest>();
    }

    public boolean addNewItem(Interest item){
        if(findItem(item.getId()) >=0){
            System.out.println("Contact is already on file");
            return false;
        }
        myItems.add(item);
        return true;
    }

    private int findItem(Interest searchItem){
        return this.myItems.indexOf(searchItem);
    }
    private int findItem(int searchItem){
        for(int i=0; i<this.myItems.size(); i++){
            Interest item = this.myItems.get(i);
            if(item.getId() == searchItem){
                return i;
            }
        }
        return -1;

    }
    public void printItems(){
        for(int i=0;i<this.myItems.size(); i++){
            System.out.println((i+1) + "." + this.myItems.get(i).getId() + " -> "
                    + this.myItems.get(i).getName());
        }
    }
}

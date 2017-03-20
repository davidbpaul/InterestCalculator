package com.davidbpaul;

import java.util.Scanner;

public class Main {
//    create entry point for taking input
    private static Scanner scanner = new Scanner(System.in);

    private static String name;
    private static double initialInvestment;
    private static double rate;
    private static int years;

    private static Value submit = new Value();


    public static void main(String[] args) {
//  print out actions
        boolean quit = false;
        startApp();
        printActions();
        while(!quit){
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    getName();
                    getInitialInvestment();
                    getRate();
                    getYears();
                    addNewItem();
                    break;
                case 2:
                    submit.printItems();
                    break;
                case 3:
                    updateExitstingItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    queryItem();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }
//  welcome message
    private static void startApp(){
        System.out.println("--Welcome To The Interest Calculator Pro--");

    }
//    print actions available
    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to add a new item\n" +
                "2 - to print items\n" +
                "3 - to update existing item\n" +
                "4 - to remove existing item\n" +
                "5 - print out investment results of item\n" +
                "6 - to print actions available list\n");
    }
//    add a new item
    private static void addNewItem(){
        Interest newItem = Interest.createItem(name, initialInvestment, rate, years);
        if(submit.addNewItem(newItem)){
            System.out.println("New Item added");
        }else{
            System.out.println("Item already on file");
        }
    }



    //	ask for user to input name. returns string
    private static String getName() {
        System.out.println("Please Enter Your Name Below ->");
        name = scanner.nextLine();
        return name;
    }
    //	ask for user to input investment. returns double
    private static double getInitialInvestment() {
        while (true) {
            try {
                System.out.println("Please Enter Your Initial Investment Below ->");
                initialInvestment = Double.parseDouble(scanner.next());
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
        return initialInvestment;
    }

    //  ask user to input rate.returns double
    private static double getRate() {
        while (true) {
            try {
                System.out.println("Please Enter Your Investment Rate ->");
                rate = Double.parseDouble(scanner.next());
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
        return rate;
    }
    //	ask user to input years. returns integer
    private static int getYears() {
        while (true) {
            try {
                System.out.println("Please Enter Length of Investment ->");
                years = Integer.parseInt(scanner.next());
                break; // will only get to here if input was a integer
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
        return years;

    }
//    remove item
    private static void removeItem(){
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Interest existingItemRecord = submit.queryItem(name);
        if(existingItemRecord == null){
            System.out.println(" Item not found");
            return;
        }
        if(submit.removeItem(existingItemRecord )){
            System.out.println("Successfully deleted");
        }else{
            System.out.println("Error deleting Item");
        }
    }

//    update item
    private static void updateExitstingItem() {
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Interest existingItemRecord = submit.queryItem(name);
        if (existingItemRecord == null) {
            System.out.println(" Item not found");
            return;
        }
        System.out.println("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new initial amount: ");
        double newInterest = scanner.nextDouble();
        System.out.println("Enter new rate: ");
        double newRate = scanner.nextDouble();
        System.out.println("Enter new length of investment: ");
        int newYears = scanner.nextInt();
        Interest newItem = Interest.createItem(newName, newInterest, newRate, newYears);
        if (submit.updateItem(existingItemRecord, newItem)) {
            System.out.println("Successfully updated record");

        } else {
            System.out.println("Error updating record");
        }
    }

//    Select a item. print out the investment results
    private static void queryItem(){
        System.out.println("Enter existing name: ");
        String name = scanner.nextLine();
        Interest existingItemRecord = submit.queryItem(name);
        if(existingItemRecord == null){
            System.out.println(" Item not found");
            return;
        }
        name = existingItemRecord.getName();
        initialInvestment = existingItemRecord.getInterest();
        rate = existingItemRecord.getRate();
        years = existingItemRecord.getYears();
        submit.printArray(name, initialInvestment, rate, years, submit.calculate(initialInvestment, rate, years));

    }

}

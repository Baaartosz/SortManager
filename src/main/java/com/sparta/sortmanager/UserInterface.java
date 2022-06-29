package com.sparta.sortmanager;

import java.util.Scanner;

public class UserInterface {

    private static final String PROGRAM_TITLE = "\n   ____         __    __  ___                           \n  / __/__  ____/ /_  /  |/  /__ ____  ___ ____ ____ ____\n _\\ \\/ _ \\/ __/ __/ / /|_/ / _ `/ _ \\/ _ `/ _ `/ -_) __/\n/___/\\___/_/  \\__/ /_/  /_/\\_,_/_//_/\\_,_/\\_, /\\__/_/   \n   Developed by Bartosz                  /___/          \n".formatted();
    private static  Scanner inputScanner = new Scanner(System.in);
    private static Algorithms[] algoEnumValues = Algorithms.values();

    private static Algorithms userAlgorithmChoice;

    public static Algorithms getUserAlgorithmChoice() {
        return userAlgorithmChoice;
    }

    private static int arraySize;

    public static int getArraySize() {
        return arraySize;
    }

    public static void start(){
        displayAlgorithms();
        getAlgorithmChoice();
        getArraySizeFromUser();
    }

    public static void title(){
        System.out.println(PROGRAM_TITLE);
    }

    private static void displayAlgorithms(){
        System.out.println("Select a sorting algorithm...");
        for (Algorithms algo: algoEnumValues) {
            System.out.println("(" + algo.ordinal() + ") : " + algo.getName());
        }
    }

    private static void getAlgorithmChoice(){
        do{ // FIXME formatting bug
            System.out.println("> ");
            String userInput = inputScanner.nextLine();
            if(validInt(userInput)){
                int validated = Integer.parseInt(userInput);
                if(validated >= algoEnumValues[0].ordinal() && validated <= algoEnumValues[algoEnumValues.length - 1].ordinal()){
                    userAlgorithmChoice = algoEnumValues[validated];
                    break;
                } else System.err.println("Invalid Selection1!");
            }else System.err.println("Invalid Selection2!");

        }while(true);
    }

    private static boolean validInt(String intString){
        if(intString == null || intString.length() == 0) return false;
        for(char c : intString.toCharArray()){
            if(c < '0' || c > '9'){
                return false;
            }
        }
        return true;
    }

    private static void getArraySizeFromUser(){
        System.out.println("Please enter the size of the array.");
        do{
            System.out.print("> ");
            String userInput = inputScanner.nextLine();
            if(validInt(userInput)){
                int validated = Integer.parseInt(userInput);
                if(validated >= 4 && validated <= Integer.MAX_VALUE - 4) {
                    arraySize = validated;
                    break;
                } else {
                    System.err.println("Array size is invalid!");
                }
            } else {
                System.err.println("Please enter a number!");
            }
        }while(true);
    }
}

package com.sparta.bart.sortmanager.view;

import com.sparta.bart.sortmanager.controller.Sorters;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private final Scanner inputScanner = new Scanner(System.in);
    private final Sorters[] algoEnumValues = Sorters.values();

    private Sorters userAlgorithmChoice;

    public Sorters getAlgorithmChoice() {
        return userAlgorithmChoice;
    }

    private int arraySize;

    public int getArraySize() {
        return arraySize;
    }

    public void title(){
        String PROGRAM_TITLE = "\n   ____         __    __  ___                           \n  / __/__  ____/ /_  /  |/  /__ ____  ___ ____ ____ ____\n _\\ \\/ _ \\/ __/ __/ / /|_/ / _ `/ _ \\/ _ `/ _ `/ -_) __/\n/___/\\___/_/  \\__/ /_/  /_/\\_,_/_//_/\\_,_/\\_, /\\__/_/   \n   Developed by Bartosz                  /___/          ";
        System.out.println(PROGRAM_TITLE);
    }

    public void informUserOfArrayFilling(){
        System.out.println("\nRandomly filling array with " + arraySize + " integers.");
    }

    public void informUserOfArraySorting(){
        System.out.println("\nWorking on sorting the array... ( This could take a while! )");
    }

    public void displayAlgorithms(){
        System.out.println("\nSelect a sorting algorithm...\nYou can select multiple by using commas between them. e.g '0,2,4'");
        for (Sorters algo: algoEnumValues) {
            System.out.println("(" + algo.ordinal() + ") : " + algo.getName());
        }
    }

    public boolean doesUserWantToContinue(){
        while (true) {
            System.out.print("\nWould you like to continue? (y)es or (n)o?\n> ");
            String userInput = inputScanner.nextLine();
            if(userInput.equals("y")) return true;
            if(userInput.equals("n")) return false;
        }
    }

    private ArrayList<Sorters> validateIntegers(String str){
        var safeChoices = new ArrayList<Sorters>();
        var rejectedChoices = new ArrayList<String>();

        var splitString = str.split(",");
        for (String possibleInt: splitString) {
            if(validInt(possibleInt) && possibleInt.length() <= algoEnumValues.length){
                int validated = Integer.parseInt(possibleInt);
                if(validated >= algoEnumValues[0].ordinal() && validated <= algoEnumValues[algoEnumValues.length - 1].ordinal()){
                    safeChoices.add(algoEnumValues[validated]); // Convert to list?
                } else {
                    rejectedChoices.add(possibleInt);
                }
            }else {
                rejectedChoices.add(possibleInt);
            }
        }
        if(!rejectedChoices.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring: ");
            for (int i = 0; i < rejectedChoices.size(); i++) {
                stringBuilder.append(rejectedChoices.get(i));
                if (i < rejectedChoices.size() - 1) stringBuilder.append(", ");
            }
            System.out.println(stringBuilder);
        }
        return safeChoices;
    }
    public ArrayList<Sorters> askForAlgorithms(){
        ArrayList<Sorters> choices = new ArrayList<>();
        while (choices.isEmpty()) {
            System.out.print("> ");
            choices = validateIntegers(inputScanner.nextLine());
        }
        return choices;
    }

    public void getSingleAlgorithmChoiceFromUser(){
        do{
            System.out.print("> ");
            String userInput = inputScanner.nextLine();
            if(validInt(userInput) && userInput.length() <= algoEnumValues.length){
                int validated = Integer.parseInt(userInput);
                if(validated >= algoEnumValues[0].ordinal() && validated <= algoEnumValues[algoEnumValues.length - 1].ordinal()){
                    userAlgorithmChoice = algoEnumValues[validated]; // Convert to list?
                    break;
                } else System.out.println("Invalid Selection!");
            }else System.out.println("Invalid Selection!");
        }while(true);
    }

    private boolean validInt(String intString){
        if(intString == null || intString.length() == 0) return false;
        for(char c : intString.toCharArray()){
            if(c < '0' || c > '9'){
                return false;
            }
        }
        return true;
    }

    public void getArraySizeFromUser(){
        System.out.println("\nPlease enter the size of the array.");
        do{
            System.out.print("> ");
            String userInput = inputScanner.nextLine();
            if(validInt(userInput) && userInput.length() <= 10){
                int validated = Integer.parseInt(userInput);
                if(validated >= 4 && validated <= Integer.MAX_VALUE/4) {
                    arraySize = validated;
                    break;
                } else {
                    System.out.println("Array size is invalid! (Enter a number above or equal to 4)");
                }
            } else {
                System.out.println("Array size is invalid! (Enter a number above or equal to 4)");
            }
        }while(true);
    }

}

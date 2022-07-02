package com.sparta.sortmanager;

public class SortManagerApp {
    public static void start(){
        UserInterface.title();
        do{
            UserInterface.setup();
            SortHandler s = new SortHandler(UserInterface.getUserAlgorithmChoice(), UserInterface.getArraySize());

            UserInterface.informUserOfArrayFilling();
            s.fillArray();

            UserInterface.informUserOfArraySorting();
            s.sortArray();
            s.outputData();

        } while(UserInterface.doesUserWantToContinue());
    }
}

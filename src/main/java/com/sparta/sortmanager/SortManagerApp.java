package com.sparta.sortmanager;

public class SortManagerApp {
    public static void start(){
        UserInterface ui = new UserInterface();
        ui.title();
        do{
            ui.displayAlgorithms();
            ui.getAlgorithmChoiceFromUser();
            ui.getArraySizeFromUser();

            SortHandler s = new SortHandler(ui.getAlgorithmChoice(), ui.getArraySize());

            ui.informUserOfArrayFilling();
            s.fillArray();

            ui.informUserOfArraySorting();
            s.sortArray();
            s.outputData();

        } while(ui.doesUserWantToContinue());
    }
}

package com.sparta.bart.sortmanager;

import com.sparta.bart.sortmanager.controller.SortController;
import com.sparta.bart.sortmanager.view.SortView;
import com.sparta.bart.sortmanager.view.UserInterface;

public class SortManager {
    public static void start(){
        UserInterface ui = new UserInterface();
        SortView view = new SortView();

        ui.title();
        do {
            ui.displayAlgorithms();

            var algorithmsChosen =  ui.askForAlgorithms();
            ui.getArraySizeFromUser();

            SortController controller = new SortController(algorithmsChosen, ui.getArraySize(), view);

            ui.informUserOfArraySorting();

            controller.sortArray();
            controller.printReport();

        } while(ui.doesUserWantToContinue());
    }
}

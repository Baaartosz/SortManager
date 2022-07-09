package com.sparta.bart.sortmanager.controller;

import com.sparta.bart.sortmanager.view.SortView;
import com.sparta.bart.sortmanager.view.UserInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortManager {

    private static final Logger logger = LogManager.getLogger(SortManager.class);
    public static void start(){
        UserInterface ui = new UserInterface();
        SortView view = new SortView();

        ui.title();
        do {
            ui.displayAlgorithms();
            // TODO cleanup user-interface functions.
            var algorithmsChosen =  ui.askForAlgorithms();
            ui.getArraySizeFromUser();

            SortController controller = new SortController(algorithmsChosen, ui.getArraySize(), view);

            ui.informUserOfArraySorting();

            controller.sortArray();
            controller.printReport();

        } while(ui.doesUserWantToContinue());
    }
}

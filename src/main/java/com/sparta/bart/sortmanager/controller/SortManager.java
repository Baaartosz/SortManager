package com.sparta.bart.sortmanager.controller;

import com.sparta.bart.sortmanager.view.SortView;
import com.sparta.bart.sortmanager.view.UserInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortManager{

    public static final Logger LOGGER = LogManager.getLogger("Sort Manager");
    public static void start(){
        SortManager.LOGGER.info("Starting up application");
        UserInterface ui = new UserInterface();
        SortView view = new SortView();

        ui.title();
        do {
            ui.displayAlgorithms();

            var algorithmsChosen =  ui.askForAlgorithms();
            var arraySize = ui.getArraySizeFromUser();

            LOGGER.debug("Algorithms chosen by the user -> " + Arrays.toString(algorithmsChosen.toArray()));
            LOGGER.debug("Array size chosen by user -> " + arraySize);

            SortController controller = new SortController(algorithmsChosen, arraySize, view);

            ui.informUserOfArraySorting();

            controller.sortArray();
            controller.printReport();

        } while(ui.doesUserWantToContinue());
        LOGGER.info("Ending Application.");
    }
}

package com.sparta.bart.sortmanager.controller;

import com.sparta.bart.sortmanager.view.SortView;
import com.sparta.bart.sortmanager.view.ConsoleView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortManager {
    public static final Logger LOGGER = LogManager.getLogger("SortManager");
    public static void start(){
        LOGGER.info("SortManager --> start()");
        ConsoleView consoleView = new ConsoleView();
        SortView view = new SortView();

        consoleView.title();
        do {
            consoleView.displayAlgorithms();

            var algorithmsChosen =  consoleView.askForAlgorithms();
            var arraySize = consoleView.askForArray();

            LOGGER.debug("Algorithms chosen by the user -> " + Arrays.toString(algorithmsChosen.toArray()));
            LOGGER.debug("Array size chosen by user -> " + arraySize);

            SortController controller = new SortController(algorithmsChosen, arraySize, view);
            consoleView.informUserOfArraySorting();

            controller.sortArray();
            controller.printReport();

        } while(consoleView.doesUserWantToContinue());
        LOGGER.info("SortManager --> shutting down");
    }
}

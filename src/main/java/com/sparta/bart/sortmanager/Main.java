package com.sparta.bart.sortmanager;

import com.sparta.bart.sortmanager.controller.SortManager;

public class Main {
    public static void main(String[] args) {
        SortManager.LOGGER.info("_______________ NEW RUN _______________");
        SortManager.start();
    }
}
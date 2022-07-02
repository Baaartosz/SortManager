package com.sparta.sortmanager;

import java.util.concurrent.TimeUnit;
public class Timer {

    protected long timeTaken = -1;
    private long startTime;

    public String getTimeTaken(){
        long s = TimeUnit.NANOSECONDS.toSeconds(timeTaken);
        long ms = TimeUnit.NANOSECONDS.toMillis(timeTaken);
        long micro = TimeUnit.NANOSECONDS.toMicros(timeTaken);

        if(micro < 9999) return micro + " microsecond(s)";
        else if(ms < 999) return ms + " millisecond(s)";
        return s + " second(s)";
    }

    public void start(){
        startTime = System.nanoTime();
    }

    public void end(){
        timeTaken = (System.nanoTime() - startTime);
        startTime = 0;
    }
}

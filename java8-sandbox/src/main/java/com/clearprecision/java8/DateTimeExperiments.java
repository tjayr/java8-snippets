package com.clearprecision.java8;

import java.time.Instant;
import java.time.LocalDateTime;

import static java.time.Clock.systemUTC;

public class DateTimeExperiments {


    public Instant getTime() {
        return systemUTC().instant();
    }


    public void addTimes() {
        
    }


    public static void println(Object o) {
        System.out.println(o);
    }


    public static void main(String[] args) {
        DateTimeExperiments dte = new DateTimeExperiments();
        println(dte.getTime());
    }

}

package com.clearprecision.java8.concurrency;

public final class MyImmutableClass {

    private final String data;

    public MyImmutableClass(String data) {
        this.data = data;
        Integer integ=0;
    }

    public String getData() {
        return data;
    }    

}

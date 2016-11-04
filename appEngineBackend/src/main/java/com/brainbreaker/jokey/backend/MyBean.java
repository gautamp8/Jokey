package com.brainbreaker.jokey.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myJoke;

    public String getMyJoke() {
        return myJoke;
    }

    public void setMyJoke(String joke) {
        myJoke = joke;
    }
}
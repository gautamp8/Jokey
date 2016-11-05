package com.brainbreaker.jokey.backend;

import com.brainbreaker.jokesprovider.Joker;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private Joker joker;

    MyBean() {
        joker = new Joker();
    }

    public String getJoke() {
        return joker.getRandomJoke();
    }

}
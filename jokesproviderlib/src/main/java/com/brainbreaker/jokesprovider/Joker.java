package com.brainbreaker.jokesprovider;
import java.util.Random;
/**
 * Tells jokes.
 */
public class Joker {

    private String[] JOKES;
    private Random random;
    public Joker(){
        JOKES = new String[3];
        JOKES[0] = "A recent worldwide survey showed that out of 2,146,703,436 people, 94% were too lazy to actually read that number.";
        JOKES[1] = "Whoever invented knock knock jokes should get a no bell prize.";
        JOKES[2] = "How come oysters never donate to charity? Because they are shellfish.";
        random = new Random();
    }

    /**
     * Tells a random joke.
     */
    public String getRandomJoke() {
        return JOKES[random.nextInt(JOKES.length)];
    }
}

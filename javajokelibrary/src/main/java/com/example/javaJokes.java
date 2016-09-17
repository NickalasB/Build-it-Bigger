package com.udacity.gradle.builditbigger;


import java.util.Random;


import java.util.Random;

public class javaJokes {
    public Random mRandom = new Random();
    String randomPunchLine;


    public String getJavaJoke1() {
        String[] jokeList = new String[]{
                "A penguin wearing sunglasses!",
                "Corgis!",
                "Turtles that wear pants!",
                "Chocolate covered olives!",
                "Steve Gutenberg!",
                "He-Man!",
                "Dudes named Floyd!"};
        int INDEXn = mRandom.nextInt(jokeList.length);
        for (int i2 = 0; i2 < INDEXn; i2++) {
            randomPunchLine = (String)(jokeList[INDEXn]);

        }

        return randomPunchLine;
    }

}



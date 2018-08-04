package com.petya.build.displayprogrammingjokeslibrary;

import java.util.Random;

/**
 * Created by Petya Marinova on 8/3/2018.
 */
public class TellNerdJoke {
    private static String[] jokes = {
            "If doctors were like software engineers, they would say things like “Have you tried killing yourself and being reborn? ",
            "Debugging  is like being the detective in a crime drama where you are also the murderer.",
            "“Knock, knock. \n" +
                    "“Who’s there? \n" +
                    "[very long pause] “Java. ",
            "An SQL query goes into a bar, walks up to two tables and asks: “Can I join you? ",
            "When Apple employees die, does their life HTML5 in front of their eyes?",
            "What did the router say to the doctor?\n" +
                    "“It hurts when IP ",
            "Why do Java programmers have to wear glasses?\n" +
                    "Because they don’t C#."};

    public static String tellJoke() {
        Random random = new Random();
        return jokes[random.nextInt(jokes.length)];
    }
}

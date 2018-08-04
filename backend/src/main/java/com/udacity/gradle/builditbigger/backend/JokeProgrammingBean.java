package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class JokeProgrammingBean {

    private String myNerdJoke;

    public String getMyNerdJoke() {
        return myNerdJoke;
    }

    public void setMyNerdJoke(String myNerdJoke) {
        this.myNerdJoke = myNerdJoke;
    }
}
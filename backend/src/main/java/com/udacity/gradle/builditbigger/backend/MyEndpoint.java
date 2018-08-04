package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.petya.build.displayprogrammingjokeslibrary.TellNerdJoke;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
//private static final String[] programmingJokes={
//        "If doctors were like software engineers, they would say things like “Have you tried killing yourself and being reborn? ",
//        "Debugging  is like being the detective in a crime drama where you are also the murderer.",
//        "“Knock, knock. \n" +
//                "“Who’s there? \n" +
//                "[very long pause] “Java. ",
//        "An SQL query goes into a bar, walks up to two tables and asks: “Can I join you? ",
//        "When Apple employees die, does their life HTML5 in front of their eyes?",
//        "What did the router say to the doctor?\n" +
//                "“It hurts when IP ",
//        "Why do Java programmers have to wear glasses?\n" +
//                "Because they don’t C#."
//};
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    public JokeProgrammingBean getJoke() {
        JokeProgrammingBean bean = new JokeProgrammingBean();
        bean.setMyNerdJoke(TellNerdJoke.tellJoke());
        return bean;

    }

}

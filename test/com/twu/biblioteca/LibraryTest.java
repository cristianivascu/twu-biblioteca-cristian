package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LibraryTest {

    Library bangaloreLibrary;

    @Before
    public void setup(){
        bangaloreLibrary = new Library();
        bangaloreLibrary.register();
    }

    @Test
    public void shouldValidateLogin(){
        String userInput = "777-7777\nabcde\n";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertTrue(bangaloreLibrary.login());

        userInput = "888-8888\nabcde\n";
        in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        assertFalse(bangaloreLibrary.login());

        System.setIn(System.in);
    }

}

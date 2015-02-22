package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PresenterTest {

    Presenter presenter;

    @Before
    public void setUp() throws Exception{
        presenter = new Presenter();
    }

    @Test
    public void shouldDisplayAListAsMenuOptions() {
        List<String> hello = new ArrayList<String>();
        hello.add("hello");
        hello.add("world");
        assertEquals("1. hello\n2. world\n", presenter.displayItemsAsMenuOptions(hello));
    }

    @Test
    public void shouldReturnUserInput() {

        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);
        assertEquals(4, presenter.getUserInput(5));
        System.setIn(System.in);

    }

    @Test
    public void shouldAskAnotherInputAfterInvalidChoice() {
        ByteArrayInputStream in = new ByteArrayInputStream("6\n3".getBytes());
        System.setIn(in);
        assertEquals(3, presenter.getUserInput(5));
        System.setIn(System.in);
    }

    @Test
    public void shouldReturnManuallyTypedBook(){
        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        String userInput = "Harry Potter and the Philosopher's Stone\nJ. K. Rowling\n1997";
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        assertEquals(harryPotter1, presenter.getBookFromUser());

        System.setIn(System.in);
    }

}

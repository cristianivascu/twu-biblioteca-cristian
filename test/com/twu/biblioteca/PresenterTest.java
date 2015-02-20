package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PresenterTest {

    Presenter p;

    @Before
    public void setUp() throws Exception{
        p = new Presenter();
    }

    @Test
    public void shouldDisplayAListAsMenuOptions() {
        List<String> hello = new ArrayList<String>();
        hello.add("hello");
        hello.add("world");
        assertEquals("1. hello\n2. world\n", p.displayItemsAsMenuOptions(hello));
    }

}

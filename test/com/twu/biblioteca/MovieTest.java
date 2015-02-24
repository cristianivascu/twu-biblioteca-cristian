package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    @Test
    public void shouldSetAValidRating(){
        Movie m1 = new Movie("The Godfather",1972,"Francis Ford Coppola");
        assertTrue(m1.setRating(4));
        assertFalse(m1.setRating(0));
        assertFalse(m1.setRating(6));
    }

    @Test
    public void shouldReturnCorrectString(){
        Movie m1 = new Movie("The Godfather",1972,"Francis Ford Coppola");
        String expected = "The Godfather, directed by Francis Ford Coppola, released in 1972, rating: N/A";
        assertEquals(expected, m1.toString());

        m1.setRating(5);
        String expected2 = "The Godfather, directed by Francis Ford Coppola, released in 1972, rating: 5/5";
        assertEquals(expected2, m1.toString());
    }
}

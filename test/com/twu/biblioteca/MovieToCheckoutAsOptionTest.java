package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MovieToCheckoutAsOptionTest {

    private Customer alice;
    private Presenter presenter;
    private Movie godfather;
    private MovieToCheckoutAsOption movieToCheckoutAsOption;

    @Before
    public void setUp() throws Exception{
        godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        alice = mock(Customer.class);
        presenter = mock(Presenter.class);
        when(alice.checkoutMovie(godfather)).thenReturn(Message.SUCCESSFUL_MOVIE_CHECKOUT);
        movieToCheckoutAsOption = new MovieToCheckoutAsOption(alice, presenter, godfather);
    }

    @Test
    public void shouldDelegateCheckoutWithCorrectMovie(){
        movieToCheckoutAsOption.onSelect();
        verify(alice).checkoutMovie(godfather);
    }

    @Test
    public void shouldDisplayCheckoutResult(){
        movieToCheckoutAsOption.onSelect();
        verify(presenter).displayMessage(Message.SUCCESSFUL_MOVIE_CHECKOUT);
    }



}

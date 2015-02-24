package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ManualMovieCheckoutOptionTest {

    private ManualMovieCheckoutOption manualMovieCheckoutOption;
    private Presenter presenter;
    private Customer alice;
    private Movie godfather;

    @Before
    public void setUp() throws Exception{
        presenter = mock(Presenter.class);
        alice = mock(Customer.class);
        manualMovieCheckoutOption = new ManualMovieCheckoutOption(alice, presenter);
        godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        when(presenter.getMovieFromUser()).thenReturn(godfather);
        when(alice.checkoutMovie(godfather)).thenReturn(Message.SUCCESSFUL_MOVIE_CHECKOUT);
    }

    @Test
    public void shouldGetEnteredMovieFromPresenter(){
        manualMovieCheckoutOption.onSelect();
        verify(presenter).getMovieFromUser();
    }

    @Test
    public void shouldDelegateCheckoutWithCorrectMovie(){
        manualMovieCheckoutOption.onSelect();
        verify(alice).checkoutMovie(godfather);
    }

    @Test
    public void shouldDisplayCheckoutResult(){
        manualMovieCheckoutOption.onSelect();
        verify(presenter).displayMessage(alice.checkoutMovie(godfather));
    }
}

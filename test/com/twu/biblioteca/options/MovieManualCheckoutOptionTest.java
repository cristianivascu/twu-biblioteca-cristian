package com.twu.biblioteca.options;


import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Presenter;
import com.twu.biblioteca.options.MovieManualCheckoutOption;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MovieManualCheckoutOptionTest {

    private MovieManualCheckoutOption movieManualCheckoutOption;
    private Presenter presenter;
    private Customer alice;
    private Movie godfather;

    @Before
    public void setUp() throws Exception{
        presenter = mock(Presenter.class);
        alice = mock(Customer.class);
        movieManualCheckoutOption = new MovieManualCheckoutOption(alice, presenter);
        godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        when(presenter.getMovieFromUser()).thenReturn(godfather);
        when(alice.checkoutMovie(godfather)).thenReturn(Message.SUCCESSFUL_MOVIE_CHECKOUT);
    }

    @Test
    public void shouldGetEnteredMovieFromPresenter(){
        movieManualCheckoutOption.onSelect();
        verify(presenter).getMovieFromUser();
    }

    @Test
    public void shouldDelegateCheckoutWithCorrectMovie(){
        movieManualCheckoutOption.onSelect();
        verify(alice).checkoutMovie(godfather);
    }

    @Test
    public void shouldDisplayCheckoutResult(){
        movieManualCheckoutOption.onSelect();
        verify(presenter).displayMessage(alice.checkoutMovie(godfather));
    }
}

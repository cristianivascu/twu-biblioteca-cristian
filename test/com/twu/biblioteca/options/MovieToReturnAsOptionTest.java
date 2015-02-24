package com.twu.biblioteca.options;


import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Presenter;
import com.twu.biblioteca.options.MovieToReturnAsOption;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MovieToReturnAsOptionTest {

    private Customer alice;
    private Presenter presenter;
    private Movie godfather;
    private MovieToReturnAsOption movieToReturnAsOption;

    @Before
    public void setUp() throws Exception{
        godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        alice = mock(Customer.class);
        presenter = mock(Presenter.class);
        when(alice.returnMovie(godfather)).thenReturn(Message.SUCCESSFUL_MOVIE_RETURN);
        movieToReturnAsOption = new MovieToReturnAsOption(alice, presenter, godfather);
    }

    @Test
    public void shouldDelegateReturnWithCorrectMovie(){
        movieToReturnAsOption.onSelect();
        verify(alice).returnMovie(godfather);
    }

    @Test
    public void shouldDisplayReturnResult(){
        movieToReturnAsOption.onSelect();
        verify(presenter).displayMessage(Message.SUCCESSFUL_MOVIE_RETURN);
    }



}

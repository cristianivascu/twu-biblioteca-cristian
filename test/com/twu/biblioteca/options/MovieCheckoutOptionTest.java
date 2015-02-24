package com.twu.biblioteca.options;


import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Presenter;
import com.twu.biblioteca.options.MovieCheckoutOption;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MovieCheckoutOptionTest {

    private Customer alice;
    private Presenter presenter;
    private MovieCheckoutOption movieCheckoutOption;
    private int totalOptions;

    @Before
    public void setUp() throws Exception{
        Movie godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(godfather);
        alice = mock(Customer.class);
        when(alice.checkAvailableMovies()).thenReturn(movies);
        presenter = mock(Presenter.class);
        movieCheckoutOption = new MovieCheckoutOption(alice, presenter);
        totalOptions = movies.size() + 2; //a movie, enter manually, quit
        when(presenter.getUserInput(totalOptions)).thenReturn(1);

    }

    @Test
    public void shouldDisplayErrorMessageIfNoMoviesAreAvailable(){
        when(alice.checkAvailableMovies()).thenReturn(new ArrayList<Movie>());
        movieCheckoutOption.onSelect();
        verify(presenter).displayMessage(Message.NO_MOVIES);
    }

    @Test
    public void shouldDisplayAvailableOptionsAsList(){
        movieCheckoutOption.onSelect();
        verify(presenter).displayAsMenu(movieCheckoutOption.getOptions());
    }

    @Test
    public void shouldProvideCorrectMenuLimitToPresenter(){
        movieCheckoutOption.onSelect();
        verify(presenter).getUserInput(totalOptions);
    }

}

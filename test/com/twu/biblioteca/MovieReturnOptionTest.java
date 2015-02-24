package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MovieReturnOptionTest {

    private Customer alice;
    private Presenter presenter;
    private MovieReturnOption movieReturnOption;
    private int totalOptions;

    @Before
    public void setUp() throws Exception{
        Movie godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(godfather);
        alice = mock(Customer.class);
        when(alice.getCheckedOutMovies()).thenReturn(movies);
        presenter = mock(Presenter.class);
        movieReturnOption = new MovieReturnOption(alice, presenter);
        totalOptions = movies.size() + 2; //a movie, enter manually, quit
        when(presenter.getUserInput(totalOptions)).thenReturn(1);

    }

    @Test
    public void shouldDisplayErrorMessageIfNoMoviesAreAvailable(){
        when(alice.getCheckedOutMovies()).thenReturn(new ArrayList<Movie>());
        movieReturnOption.onSelect();
        verify(presenter).displayMessage(Message.NO_MOVIES);
    }

    @Test
    public void shouldDisplayAvailableOptionsAsList(){
        movieReturnOption.onSelect();
        verify(presenter).displayItemsAsMenuOptions(movieReturnOption.getOptions());
    }

    @Test
    public void shouldProvideCorrectMenuLimitToPresenter(){
        movieReturnOption.onSelect();
        verify(presenter).getUserInput(totalOptions);
    }

}

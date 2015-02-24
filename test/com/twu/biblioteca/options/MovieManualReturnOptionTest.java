package com.twu.biblioteca.options;


import com.twu.biblioteca.Customer;
import com.twu.biblioteca.Message;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Presenter;
import com.twu.biblioteca.options.MovieManualReturnOption;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MovieManualReturnOptionTest {

    private MovieManualReturnOption manualReturn;
    private Presenter presenter;
    private Customer alice;
    private Movie godfather;

    @Before
    public void setUp() throws Exception{
        presenter = mock(Presenter.class);
        alice = mock(Customer.class);
        manualReturn = new MovieManualReturnOption(alice, presenter);
        godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        when(presenter.getMovieFromUser()).thenReturn(godfather);
        when(alice.returnMovie(godfather)).thenReturn(Message.SUCCESSFUL_MOVIE_RETURN);
    }

    @Test
    public void shouldGetEnteredMovieFromPresenter(){
        manualReturn.onSelect();
        verify(presenter).getMovieFromUser();
    }

    @Test
    public void shouldDelegateReturnWithCorrectMovie(){
        manualReturn.onSelect();
        verify(alice).returnMovie(godfather);
    }

    @Test
    public void shouldDisplayReturnResult(){
        manualReturn.onSelect();
        verify(presenter).displayMessage(alice.returnMovie(godfather));
    }
}

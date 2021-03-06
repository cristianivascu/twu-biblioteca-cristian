package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {

    private Customer alice;
    private Book harryPotter1;
    private Book harryPotter2;
    private Movie godfather;
    private Movie godfather2;
    private Inventory<Book> bangaloreBookInventory;
    private Inventory<Movie> bangaloreMovieInventory;

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        godfather = new Movie("The Godfather",1972,"Francis Ford Coppola");
        godfather2 = new Movie("The Godfather Part II",1974,"Francis Ford Coppola");
        bangaloreBookInventory = mock(Inventory.class);
        bangaloreMovieInventory = mock(Inventory.class);
        alice = new Customer(bangaloreBookInventory, bangaloreMovieInventory);
    }

    @Test
    public void shouldCheckoutAvailableBook(){
        when(bangaloreBookInventory.removeItem(harryPotter1)).thenReturn(true);
        assertEquals(Message.SUCCESSFUL_BOOK_CHECKOUT, alice.checkoutBook(harryPotter1));
        when(bangaloreBookInventory.removeItem(harryPotter1)).thenReturn(false);
        assertEquals(Message.UNSUCCESSFUL_BOOK_CHECKOUT, alice.checkoutBook(harryPotter1));
    }

    @Test
    public void shouldAddCheckedOutBookToList(){
        checkOutHarryPotter1();
        assertTrue(alice.getCheckedOutBooks().contains(harryPotter1));
    }

    @Test
    public void shouldReturnCheckedOutBook(){
        checkOutHarryPotter1();
        when(bangaloreBookInventory.addItem(harryPotter1)).thenReturn(true);
        assertEquals(Message.SUCCESSFUL_BOOK_RETURN, alice.returnBook(harryPotter1));
        assertEquals(Message.UNSUCCESSFUL_BOOK_RETURN, alice.returnBook(harryPotter2));
    }

    @Test
    public void shouldReturnValidBook(){
        checkOutHarryPotter1();
        when(bangaloreBookInventory.addItem(harryPotter1)).thenReturn(false);
        assertEquals(Message.UNSUCCESSFUL_BOOK_RETURN, alice.returnBook(harryPotter1));
    }

    @Test
    public void shouldRemoveCheckedOutBookAfterReturn(){
        checkOutHarryPotter1();
        when(bangaloreBookInventory.addItem(harryPotter1)).thenReturn(true);
        alice.returnBook(harryPotter1);
        assertFalse(alice.getCheckedOutBooks().contains(harryPotter1));
    }

    @Test
    public void shouldDelegateOnLibraryToListAllBooks(){
        List<Book> returnedByLibrary = new ArrayList<Book>();
        when(bangaloreBookInventory.listAvailableItems()).thenReturn(returnedByLibrary);
        List<Book> returnedByCustomer = alice.checkAvailableBooks();
        verify(bangaloreBookInventory).listAvailableItems();
        assertEquals(returnedByLibrary,returnedByCustomer);
    }

    public void checkOutHarryPotter1() {
        when(bangaloreBookInventory.removeItem(harryPotter1)).thenReturn(true);
        alice.checkoutBook(harryPotter1);
    }



    @Test
    public void shouldCheckoutAvailableMovie(){
        when(bangaloreMovieInventory.removeItem(godfather)).thenReturn(true);
        assertEquals(Message.SUCCESSFUL_MOVIE_CHECKOUT, alice.checkoutMovie(godfather));
        when(bangaloreMovieInventory.removeItem(godfather)).thenReturn(false);
        assertEquals(Message.UNSUCCESSFUL_MOVIE_CHECKOUT, alice.checkoutMovie(godfather));
    }

    @Test
    public void shouldAddCheckedOutMovieToList(){
        checkOutGodfather();
        assertTrue(alice.getCheckedOutMovies().contains(godfather));
    }

    @Test
    public void shouldReturnCheckedOutMovie(){
        checkOutGodfather();
        when(bangaloreMovieInventory.addItem(godfather)).thenReturn(true);
        assertEquals(Message.SUCCESSFUL_MOVIE_RETURN, alice.returnMovie(godfather));
        assertEquals(Message.UNSUCCESSFUL_MOVIE_RETURN, alice.returnMovie(godfather2));
    }

    @Test
    public void shouldReturnValidMovie(){
        checkOutGodfather();
        when(bangaloreMovieInventory.addItem(godfather)).thenReturn(false);
        assertEquals(Message.UNSUCCESSFUL_MOVIE_RETURN, alice.returnMovie(godfather));
    }

    @Test
    public void shouldRemoveCheckedOutMovieAfterReturn(){
        checkOutGodfather();
        when(bangaloreMovieInventory.addItem(godfather)).thenReturn(true);
        alice.returnMovie(godfather);
        assertFalse(alice.getCheckedOutMovies().contains(godfather));
    }

    @Test
    public void shouldDelegateOnLibraryToListAllMovies(){
        List<Movie> returnedByLibrary = new ArrayList<Movie>();
        when(bangaloreMovieInventory.listAvailableItems()).thenReturn(returnedByLibrary);
        List<Movie> returnedByCustomer = alice.checkAvailableMovies();
        verify(bangaloreMovieInventory).listAvailableItems();
        assertEquals(returnedByLibrary,returnedByCustomer);
    }

    public void checkOutGodfather() {
        when(bangaloreMovieInventory.removeItem(godfather)).thenReturn(true);
        alice.checkoutMovie(godfather);
    }

}

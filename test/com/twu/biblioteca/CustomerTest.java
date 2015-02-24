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
    private Library bangaloreLibrary;

    @Before
    public void setUp() throws Exception{
        harryPotter1 = new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997);
        harryPotter2 = new Book("Harry Potter and the Chamber of Secrets","J. K. Rowling", 1998);
        bangaloreLibrary = mock(Library.class);
        alice = new Customer(bangaloreLibrary);
    }

    @Test
    public void shouldCheckoutAvailableBook(){
        when(bangaloreLibrary.removeItem(harryPotter1)).thenReturn(true);
        assertEquals(Message.SUCCESSFUL_CHECKOUT, alice.checkout(harryPotter1));
        when(bangaloreLibrary.removeItem(harryPotter1)).thenReturn(false);
        assertEquals(Message.UNSUCCESSFUL_CHECKOUT, alice.checkout(harryPotter1));
    }

    @Test
    public void shouldAddCheckedOutBookToList(){
        checkOutHarryPotter1();
        assertTrue(alice.getCheckedOutBooks().contains(harryPotter1));
    }

    @Test
    public void shouldReturnCheckedOutBook(){
        checkOutHarryPotter1();
        when(bangaloreLibrary.addItem(harryPotter1)).thenReturn(true);
        assertEquals(Message.SUCCESSFUL_RETURN, alice.returnBook(harryPotter1));
        assertEquals(Message.UNSUCCESSFUL_RETURN, alice.returnBook(harryPotter2));
    }

    @Test
    public void shouldReturnValidBook(){
        checkOutHarryPotter1();
        when(bangaloreLibrary.addItem(harryPotter1)).thenReturn(false);
        assertEquals(Message.UNSUCCESSFUL_RETURN, alice.returnBook(harryPotter1));
    }

    @Test
    public void shouldRemoveCheckedOutBookAfterReturn(){
        checkOutHarryPotter1();
        when(bangaloreLibrary.addItem(harryPotter1)).thenReturn(true);
        alice.returnBook(harryPotter1);
        assertFalse(alice.getCheckedOutBooks().contains(harryPotter1));
    }

    @Test
    public void shouldDelegateOnLibraryToListAllBooks(){
        List<Book> returnedByLibrary = new ArrayList<Book>();
        when(bangaloreLibrary.listAvailableItems()).thenReturn(returnedByLibrary);
        List<Book> returnedByCustomer = alice.checkAvailableBooks();
        verify(bangaloreLibrary).listAvailableItems();
        assertEquals(returnedByLibrary,returnedByCustomer);
    }

    public void checkOutHarryPotter1() {
        when(bangaloreLibrary.removeItem(harryPotter1)).thenReturn(true);
        alice.checkout(harryPotter1);
    }

}

package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserInterfaceTest {

    private Customer alice;
    private Presenter presenter;
    private UserInterface ui;
    private List<Option> menuOptions = new ArrayList<Option>();
    private Option checkoutOption;
    private Option listOption;

    @Before
    public void setUp() throws Exception{
        alice = mock(Customer.class);
        presenter = mock(Presenter.class);
        checkoutOption = mock(CheckoutOption.class);
        listOption = mock(ListOption.class);
        menuOptions.add(listOption);
        menuOptions.add(checkoutOption);
        ui = new UserInterface(alice, presenter, menuOptions);
    }

    @Test
    public void shouldReturnValidUserInput() {

        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);
        assertEquals(4, ui.getUserInput(5));
        System.setIn(System.in);

    }

    @Test
    public void shouldDisplayErrorWhenInputInvalid() {
        ByteArrayInputStream in = new ByteArrayInputStream("6\n3".getBytes());
        System.setIn(in);
        ui.getUserInput(5);
        verify(presenter).displayMessage(Message.INVALID_MENU_OPTION);
        System.setIn(System.in);
    }

    @Test
    public void shouldDisplayMainMenuOptions(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        ui.mainMenu();
        verify(presenter).displayItemsAsMenuOptions(menuOptions);
        System.setIn(System.in);
    }

    @Test
    public void shouldDelegateOnFirstOptionIfChosen(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        ui.mainMenu();
        verify(listOption).onSelect();
        System.setIn(System.in);
    }

    @Test
    public void shouldDelegateOnSecondOptionIfChosen(){
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        ui.mainMenu();
        verify(checkoutOption).onSelect();
        System.setIn(System.in);
    }
}

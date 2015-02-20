package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserInterfaceTest {

    private Customer alice;
    private Presenter presenter;
    private UserInterface ui;
    private List<Option> menuOptions = new ArrayList<Option>();
    private Option checkoutOption;

    @Before
    public void setUp() throws Exception{
        alice = mock(Customer.class);
        presenter = mock(Presenter.class);
        checkoutOption = mock(CheckoutOption.class);
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
        System.setIn(in);
    }

    @Test
    public void shouldDisplayMainMenuOptions(){
        ui.showMainMenu();
        verify(presenter).displayItemsAsMenuOptions(menuOptions);
    }

    @Test
    public void shouldDelegateOnOptions(){
        ui.showMainMenu();
        verify(checkoutOption).onSelect();
    }
}

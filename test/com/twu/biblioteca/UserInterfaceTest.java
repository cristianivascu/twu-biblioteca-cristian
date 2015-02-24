package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserInterfaceTest {

    private Presenter presenter;
    private UserInterface ui;
    private List<Option> menuOptions = new ArrayList<Option>();
    private Option listOption;
    private Option checkoutOption;
    private Option returnOption;
    private Option quitOption;

    @Before
    public void setUp() throws Exception{
        presenter = mock(Presenter.class);
        listOption = mock(ListBooksOption.class);
        checkoutOption = mock(BookCheckoutOption.class);
        returnOption = mock(ReturnOption.class);
        quitOption = mock(QuitOption.class);
        menuOptions.add(listOption);
        menuOptions.add(checkoutOption);
        menuOptions.add(returnOption);
        menuOptions.add(quitOption);
        ui = new UserInterface(presenter, menuOptions);
    }

    @Test
    public void shouldDisplayMainMenuOptions(){
        when(presenter.getUserInput(4)).thenReturn(4);
        ui.mainMenu();
        verify(presenter).displayItemsAsMenuOptions(menuOptions);
    }

    @Test
    public void shouldProvideCorrectMenuLimitToPresenter(){
        when(presenter.getUserInput(4)).thenReturn(4);
        ui.mainMenu();
        verify(presenter).getUserInput(menuOptions.size());
    }

    @Test
    public void shouldDelegateOnChosenOption(){
        when(presenter.getUserInput(4)).thenReturn(1,2,3,4);
        ui.mainMenu();
        verify(listOption).onSelect();
        verify(checkoutOption).onSelect();
        verify(returnOption).onSelect();
        verify(quitOption).onSelect();
    }



}

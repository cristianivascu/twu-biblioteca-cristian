package com.twu.biblioteca;


import com.twu.biblioteca.options.BookCheckoutOption;
import com.twu.biblioteca.options.BookReturnOption;
import com.twu.biblioteca.options.Option;
import com.twu.biblioteca.options.QuitOption;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserInterfaceTest {

    private Presenter presenter;
    private UserInterface ui;
    private List<Option> menuOptions = new ArrayList<Option>();
    private Option checkoutOption;
    private Option returnOption;
    private Option quitOption;

    @Before
    public void setUp() throws Exception{
        presenter = mock(Presenter.class);
        checkoutOption = mock(BookCheckoutOption.class);
        returnOption = mock(BookReturnOption.class);
        quitOption = mock(QuitOption.class);
        menuOptions.add(checkoutOption);
        menuOptions.add(returnOption);
        menuOptions.add(quitOption);
        ui = new UserInterface(presenter, menuOptions);
    }

    @Test
    public void shouldDisplayMainMenuOptions(){
        when(presenter.getUserInput(3)).thenReturn(3);
        ui.mainMenu();
        verify(presenter).displayAsMenu(menuOptions);
    }

    @Test
    public void shouldProvideCorrectMenuLimitToPresenter(){
        when(presenter.getUserInput(3)).thenReturn(3);
        ui.mainMenu();
        verify(presenter).getUserInput(menuOptions.size());
    }

    @Test
    public void shouldDelegateOnChosenOption(){
        when(presenter.getUserInput(3)).thenReturn(1,2,3);
        ui.mainMenu();
        verify(checkoutOption).onSelect();
        verify(returnOption).onSelect();
        verify(quitOption).onSelect();
    }



}

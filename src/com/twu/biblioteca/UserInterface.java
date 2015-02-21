package com.twu.biblioteca;

import java.util.List;

public class UserInterface {

    private Presenter presenter;

    private List<Option> menuOptions;

    public UserInterface(Presenter presenter, List<Option> menuOptions) {
        this.presenter = presenter;
        this.menuOptions = menuOptions;
    }

    public void mainMenu(){
        Option optionSelected;
        do{
            presenter.displayItemsAsMenuOptions(menuOptions);
            int userInput = presenter.getUserInput(menuOptions.size());
            optionSelected = menuOptions.get(userInput-1);
            optionSelected.onSelect();
        }while(!(optionSelected instanceof QuitOption));
    }


}

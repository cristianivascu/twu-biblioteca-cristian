package com.twu.biblioteca.options;

import com.twu.biblioteca.*;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemActionOption implements Option {
    Customer customer;
    Presenter presenter;
    List<Option> options = new ArrayList<Option>();

    @Override
    public void onSelect() {
        List<? extends Item> items = getItems();

        if(items.isEmpty()){
            displayNoItemsMessage();
        }else {
            int manualOptionIndex = items.size()+1;
            int exitOptionIndex = items.size()+2;
            presenter.displayItemsAsMenu(items);
            int chosenOptionNumber = presenter.getUserInput(exitOptionIndex);
            if(chosenOptionNumber == manualOptionIndex){
                itemAction(getItemManually());
            }else if(chosenOptionNumber < manualOptionIndex){
                itemAction(items.get(chosenOptionNumber - 1));
            }
        }
    }

    abstract List<? extends Item> getItems();
    abstract void displayNoItemsMessage();
    abstract Item getItemManually();
    abstract void itemAction(Item item);

    public List<Option> getOptions() {
        return new ArrayList<Option>(options);
    }

    @Override
    public abstract String toString();

}

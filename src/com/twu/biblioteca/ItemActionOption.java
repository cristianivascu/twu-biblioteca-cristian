package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemActionOption implements Option{
    Customer customer;
    Presenter presenter;
    List<Option> options = new ArrayList<Option>();

    @Override
    public void onSelect() {
        List<? extends Item> items = getItems();

        if(items.isEmpty()){
            displayNoItemsMessage();
        }else {
            initialiseOptions(items);
            presenter.displayItemsAsMenuOptions(options);
            int chosenOptionNumber = presenter.getUserInput(options.size());
            Option selectedOption = options.get(chosenOptionNumber - 1);
            selectedOption.onSelect();
        }
    }

    abstract List<? extends Item> getItems();
    abstract void displayNoItemsMessage();
    abstract Option convertItemToOption(Item item);
    abstract Option getManualOption();

    private void initialiseOptions(List<? extends Item> items) {
        options = new ArrayList<Option>();
        for(Item item:items){
            options.add(convertItemToOption(item));
        }
        options.add(getManualOption());
        options.add(new QuitOption());
    }

    public List<Option> getOptions() {
        return new ArrayList<Option>(options);
    }

    @Override
    public abstract String toString();

}

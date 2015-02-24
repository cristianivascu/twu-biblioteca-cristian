package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory<T extends Item> {

    private Map<T, Integer> items;

    public Inventory(Map<T, Integer> items) {
        //defensive copying, only Inventory should manage the data
        this.items = new HashMap<T, Integer>(items);
    }

    public Map<T, Integer> getItems() {

        return new HashMap<T, Integer>(items);
    }

    public boolean addItem(T item) {
        if (item ==null)
            return false;
        int quantity = items.containsKey(item) ? items.get(item) : 0;
        items.put(item, quantity + 1);
        return true;
    }

    public boolean removeItem(T item) {
        if(!items.containsKey(item) || items.get(item) == 0)
            return false;
        items.put(item, items.get(item)-1);
        return true;
    }

    public List<T> listAvailableItems() {
        List<T> availableItems = new ArrayList<T>();
        for(T item: items.keySet()){
            if(items.get(item)>0)
               availableItems.add(item);
        }
        return availableItems;
    }
}

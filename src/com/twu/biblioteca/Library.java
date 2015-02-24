package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library <T extends Item> {

    private Map<T, Integer> inventory;

    public Library(Map<T, Integer> inventory) {
        //defensive copying, only Library should manage the inventory
        this.inventory = new HashMap<T, Integer>(inventory);
    }

    public Map<T, Integer> getInventory() {

        return new HashMap<T, Integer>(inventory);
    }

    public boolean addItem(T item) {
        if (item ==null)
            return false;
        int quantity = inventory.containsKey(item) ? inventory.get(item) : 0;
        inventory.put(item,quantity+1);
        return true;
    }

    public boolean removeItem(T item) {
        if(!inventory.containsKey(item) || inventory.get(item) == 0)
            return false;
        inventory.put(item, inventory.get(item)-1);
        return true;
    }

    public List<T> listAvailableItems() {
        List<T> availableItems = new ArrayList<T>();
        for(T item:inventory.keySet()){
            if(inventory.get(item)>0)
               availableItems.add(item);
        }
        return availableItems;
    }
}

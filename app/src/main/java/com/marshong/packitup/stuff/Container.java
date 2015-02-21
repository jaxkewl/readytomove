package com.marshong.packitup.stuff;

import java.lang.String;
import java.util.ArrayList;

/**
 * Created by martin on 2/20/2015.
 */
public class Container {
    private String name;
    private Globals.Rooms room;
    private ArrayList<Item> items;


    public Container(String name, Globals.Rooms location) {
        setName(name);
        setRoom(location);
        items = new ArrayList<>();
    }

    public ArrayList<Item> getAllItems() {
        return new ArrayList<Item>(items);
    }

    public String getAllItemNames() {
        String allNames = "";

        for (Item item : items) {
            allNames += item.getName() + " ";
        }
        return allNames;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        Item itemToRemove = null;

        // find the item object by finding an item with the same name
        for (Item i : items) {
            if (i.getName().equals(item.getName())) {
                itemToRemove = i;
                break;
            }
        }

        // remove the item if we found it
        if (null != itemToRemove) {
            items.remove(itemToRemove);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Globals.Rooms getRoom() {
        return room;
    }

    public void setRoom(Globals.Rooms room) {
        this.room = room;
    }
}

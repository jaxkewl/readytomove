package com.marshong.packitup.model;

import java.lang.String;
import java.util.ArrayList;

/**
 * Created by martin on 2/20/2015.
 */
public class Container {
    private String name;
    private String location;
    private int locationID;
    private String descr;
    private ArrayList<Item> items;


    public Container(String name, String descr, String location) {
        setName(name);
        setLocation(location);
        setDescr(descr);
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    @Override
    public String toString() {
        return getName() + " " + getLocation() + " (" + getLocationID() + ") " + getDescr();
    }
}

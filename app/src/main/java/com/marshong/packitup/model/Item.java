package com.marshong.packitup.model;

import java.lang.String;

/**
 * Created by martin on 2/20/2015.
 */
public class Item {
    private String name;
    private String descr;
    private String container;
    private int containerID;

    public Item(String name, String descr) {

        setName(name);
        setDescr(descr);
    }

    public String getName() {
        return name;
    }

    public void setName(String mName) {
        this.name = mName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public int getContainerID() {
        return containerID;
    }

    public void setContainerID(int containerID) {
        this.containerID = containerID;
    }

    @Override
    public String toString() {
        return getName() + " " + getDescr() + " " + getContainer() + " (" + getContainerID() + ")";
    }
}

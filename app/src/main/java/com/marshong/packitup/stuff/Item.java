package com.marshong.packitup.stuff;

import java.lang.String; /**
 * Created by martin on 2/20/2015.
 */
public class Item {
    private String mName;

    public Item(String name) {
        setName(name);
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }
}

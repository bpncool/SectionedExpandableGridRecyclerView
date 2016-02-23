package com.fivido.sectionedexpandablegridlayout.models;

/**
 * Created by bpncool on 2/23/2016.
 */
public class Item {

    private final String name;
    private final int id;

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

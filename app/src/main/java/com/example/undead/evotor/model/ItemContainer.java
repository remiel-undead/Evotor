package com.example.undead.evotor.model;

import java.util.List;

public class ItemContainer {
    private List<Item> items;

    public ItemContainer(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

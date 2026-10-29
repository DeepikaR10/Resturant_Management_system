package com.rest.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final int id;
    private final int tableId;
    private final List<OrderItem> items = new ArrayList<>();

    public Order(int id, int tableId) {
        this.id = id;
        this.tableId = tableId;
    }

    public int getId() {
        return id;
    }

    public int getTableId() {
        return tableId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "Order ID: " + id + ", Table ID: " + tableId + ", Items: " + items.size();
    }
}
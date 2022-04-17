package org.ks.learn.shop.cart.entity;

import java.util.UUID;

public class ShoppingItem {

    public UUID uuid;

    public String name;

    public int quantity;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

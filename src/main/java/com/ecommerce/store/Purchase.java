package com.ecommerce.store;

public class Purchase {

    private Item item;
    private int quantity;

    public Purchase(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculatePurchaseTotal() {
        return item.getPrice() * quantity;
    }
}





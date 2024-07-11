package com.mercado.model;

public class OrderItem {
    private int lineItemId;
    private Product product;
    private int quantity;

    // Getters and setters
    public int getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(int lineItemId) {
        this.lineItemId = lineItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
                "\"lineItemId\": " + lineItemId + ", " +
                "\"product\": " + product + ", " +
                "\"quantity\": " + quantity +
                "}";
    }
}

package com.mercado.model;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

public class Order {
    private ObjectId id;
    private int orderId;
    private LocalDateTime orderDatetime;
    private String orderStatus;
    private Store store;
    private Customer customer;
    private List<OrderItem> orderItems;

    // Getters and setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(LocalDateTime orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id.toString() + "\", " +
                "\"orderId\": " + orderId + ", " +
                "\"orderDatetime\": \"" + orderDatetime.toString() + "\", " +
                "\"orderStatus\": \"" + orderStatus + "\", " +
                "\"store\": " + store + ", " +
                "\"customer\": " + customer + ", " +
                "\"orderItems\": " + orderItems +
                "}";
    }
}

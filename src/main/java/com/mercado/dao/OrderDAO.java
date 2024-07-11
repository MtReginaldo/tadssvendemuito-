package com.mercado.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mercado.model.*;
import com.mercado.util.MongoDBConnection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO {
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public OrderDAO() {
        this.database = MongoDBConnection.getDatabase();
        this.collection = database.getCollection("orders");
    }

    public void create(Order order) {
        Document document = new Document("orderId", order.getOrderId())
                .append("orderDatetime", Date.from(order.getOrderDatetime().atZone(ZoneId.systemDefault()).toInstant()))
                .append("orderStatus", order.getOrderStatus())
                .append("store", storeToDocument(order.getStore()))
                .append("customer", customerToDocument(order.getCustomer()))
                .append("orderItems", orderItemsToDocumentList(order.getOrderItems()));
        collection.insertOne(document);
        order.setId(document.getObjectId("_id"));
    }

    public Order read(String id) {
        Document document = collection.find(Filters.eq("_id", new ObjectId(id))).first();
        return document != null ? documentToOrder(document) : null;
    }

    public List<Order> readAll() {
        List<Order> orders = new ArrayList<>();
        for (Document document : collection.find()) {
            orders.add(documentToOrder(document));
        }
        return orders;
    }

    public void update(Order order) {
        Document document = new Document("orderId", order.getOrderId())
                .append("orderDatetime", Date.from(order.getOrderDatetime().atZone(ZoneId.systemDefault()).toInstant()))
                .append("orderStatus", order.getOrderStatus())
                .append("store", storeToDocument(order.getStore()))
                .append("customer", customerToDocument(order.getCustomer()))
                .append("orderItems", orderItemsToDocumentList(order.getOrderItems()));
        collection.updateOne(Filters.eq("_id", order.getId()), new Document("$set", document));
    }

    public void delete(String id) {
        collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }

    private Document storeToDocument(Store store) {
        return new Document("storeId", store.getStoreId())
                .append("storeName", store.getStoreName())
                .append("webAddress", store.getWebAddress())
                .append("physicalAddress", store.getPhysicalAddress())
                .append("latitude", store.getLatitude())
                .append("longitude", store.getLongitude())
                .append("logo", store.getLogo())
                .append("logoMimeType", store.getLogoMimeType())
                .append("logoFilename", store.getLogoFilename())
                .append("logoCharset", store.getLogoCharset())
                .append("logoLastUpdated", store.getLogoLastUpdated());
    }

    private Document customerToDocument(Customer customer) {
        return new Document("customerId", customer.getCustomerId())
                .append("emailAddress", customer.getEmailAddress())
                .append("fullName", customer.getFullName());
    }

    private List<Document> orderItemsToDocumentList(List<OrderItem> orderItems) {
        List<Document> documents = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            documents.add(new Document("lineItemId", orderItem.getLineItemId())
                    .append("product", productToDocument(orderItem.getProduct()))
                    .append("quantity", orderItem.getQuantity()));
        }
        return documents;
    }

    private Document productToDocument(Product product) {
        return new Document("productId", product.getProductId())
                .append("productName", product.getProductName())
                .append("unitPrice", product.getUnitPrice())
                .append("productDetails", product.getProductDetails())
                .append("productImage", product.getProductImage())
                .append("imageMimeType", product.getImageMimeType())
                .append("imageFilename", product.getImageFilename())
                .append("imageCharset", product.getImageCharset())
                .append("imageLastUpdated", product.getImageLastUpdated());
    }

    private Order documentToOrder(Document document) {
        Order order = new Order();
        order.setId(document.getObjectId("_id"));
        order.setOrderId(document.getInteger("orderId"));
        Date date = document.getDate("orderDatetime");
        order.setOrderDatetime(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        order.setOrderStatus(document.getString("orderStatus"));
        order.setStore(documentToStore(document.get("store", Document.class)));
        order.setCustomer(documentToCustomer(document.get("customer", Document.class)));
        order.setOrderItems(documentToOrderItemList((List<Document>) document.get("orderItems")));
        return order;
    }

    private Store documentToStore(Document document) {
        Store store = new Store();
        store.setStoreId(document.getInteger("storeId"));
        store.setStoreName(document.getString("storeName"));
        store.setWebAddress(document.getString("webAddress"));
        store.setPhysicalAddress(document.getString("physicalAddress"));
        store.setLatitude(document.getDouble("latitude"));
        store.setLongitude(document.getDouble("longitude"));
        store.setLogo(document.getString("logo"));
        store.setLogoMimeType(document.getString("logoMimeType"));
        store.setLogoFilename(document.getString("logoFilename"));
        store.setLogoCharset(document.getString("logoCharset"));
        store.setLogoLastUpdated(document.getString("logoLastUpdated"));
        return store;
    }

    private Customer documentToCustomer(Document document) {
        Customer customer = new Customer();
        customer.setCustomerId(document.getInteger("customerId"));
        customer.setEmailAddress(document.getString("emailAddress"));
        customer.setFullName(document.getString("fullName"));
        return customer;
    }

    private List<OrderItem> documentToOrderItemList(List<Document> documents) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (Document document : documents) {
            OrderItem orderItem = new OrderItem();
            orderItem.setLineItemId(document.getInteger("lineItemId"));
            orderItem.setProduct(documentToProduct(document.get("product", Document.class)));
            orderItem.setQuantity(document.getInteger("quantity"));
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private Product documentToProduct(Document document) {
        Product product = new Product();
        product.setProductId(document.getInteger("productId"));
        product.setProductName(document.getString("productName"));
        product.setUnitPrice(document.getDouble("unitPrice"));
        product.setProductDetails(document.getString("productDetails"));
        product.setProductImage(document.getString("productImage"));
        product.setImageMimeType(document.getString("imageMimeType"));
        product.setImageFilename(document.getString("imageFilename"));
        product.setImageCharset(document.getString("imageCharset"));
        product.setImageLastUpdated(document.getString("imageLastUpdated"));
        return product;
    }
}

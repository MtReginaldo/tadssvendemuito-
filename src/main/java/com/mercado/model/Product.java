package com.mercado.model;

public class Product {
    private int productId;
    private String productName;
    private double unitPrice;
    private String productDetails;
    private String productImage;
    private String imageMimeType;
    private String imageFilename;
    private String imageCharset;
    private String imageLastUpdated;

    // Getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getImageMimeType() {
        return imageMimeType;
    }

    public void setImageMimeType(String imageMimeType) {
        this.imageMimeType = imageMimeType;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public String getImageCharset() {
        return imageCharset;
    }

    public void setImageCharset(String imageCharset) {
        this.imageCharset = imageCharset;
    }

    public String getImageLastUpdated() {
        return imageLastUpdated;
    }

    public void setImageLastUpdated(String imageLastUpdated) {
        this.imageLastUpdated = imageLastUpdated;
    }

    @Override
    public String toString() {
        return "{" +
                "\"productId\": " + productId + ", " +
                "\"productName\": \"" + productName + "\", " +
                "\"unitPrice\": " + unitPrice + ", " +
                "\"productDetails\": \"" + productDetails + "\", " +
                "\"productImage\": \"" + productImage + "\", " +
                "\"imageMimeType\": \"" + imageMimeType + "\", " +
                "\"imageFilename\": \"" + imageFilename + "\", " +
                "\"imageCharset\": \"" + imageCharset + "\", " +
                "\"imageLastUpdated\": \"" + imageLastUpdated + "\"" +
                "}";
    }
}

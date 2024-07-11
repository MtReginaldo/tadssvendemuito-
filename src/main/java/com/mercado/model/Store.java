package com.mercado.model;

public class Store {
    private int storeId;
    private String storeName;
    private String webAddress;
    private String physicalAddress;
    private double latitude;
    private double longitude;
    private String logo;
    private String logoMimeType;
    private String logoFilename;
    private String logoCharset;
    private String logoLastUpdated;

    // Getters and setters
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogoMimeType() {
        return logoMimeType;
    }

    public void setLogoMimeType(String logoMimeType) {
        this.logoMimeType = logoMimeType;
    }

    public String getLogoFilename() {
        return logoFilename;
    }

    public void setLogoFilename(String logoFilename) {
        this.logoFilename = logoFilename;
    }

    public String getLogoCharset() {
        return logoCharset;
    }

    public void setLogoCharset(String logoCharset) {
        this.logoCharset = logoCharset;
    }

    public String getLogoLastUpdated() {
        return logoLastUpdated;
    }

    public void setLogoLastUpdated(String logoLastUpdated) {
        this.logoLastUpdated = logoLastUpdated;
    }
    @Override
    public String toString() {
        return "{" +
                "\"storeId\": " + storeId + ", " +
                "\"storeName\": \"" + storeName + "\", " +
                "\"webAddress\": \"" + webAddress + "\", " +
                "\"physicalAddress\": \"" + physicalAddress + "\", " +
                "\"latitude\": " + latitude + ", " +
                "\"longitude\": " + longitude + ", " +
                "\"logo\": \"" + logo + "\", " +
                "\"logoMimeType\": \"" + logoMimeType + "\", " +
                "\"logoFilename\": \"" + logoFilename + "\", " +
                "\"logoCharset\": \"" + logoCharset + "\", " +
                "\"logoLastUpdated\": \"" + logoLastUpdated + "\"" +
                "}";
    }
}
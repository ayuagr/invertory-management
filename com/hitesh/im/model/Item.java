package com.hitesh.im.model;

/**
 * Created by hitesh on 25/7/17.
 */
public class Item {
    private int itemId;
    private String barCode;
    private String name;
    private float sellPrice;
    private float buyPrice;
    private int stockQuantity;

    public Item(int itemId, String barCode, String name, float sellPrice, float buyPrice, int stockQuantity) {
        this.itemId = itemId;
        this.barCode = barCode;
        this.name = name;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.stockQuantity = stockQuantity;
    }

    public int getItemId() {

        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}

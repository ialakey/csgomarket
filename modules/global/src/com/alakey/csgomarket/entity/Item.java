package com.alakey.csgomarket.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "CSGOMARKET_ITEM")
@Entity(name = "csgomarket_Item")
@NamePattern("%s|id")
public class Item extends StandardEntity {
    private static final long serialVersionUID = -7752089257186548954L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "HASH_NAME")
    private String hashName;

    @Column(name = "SELL_PRICE_TEXT")
    private String sellPriceText;

    @Column(name = "SALE_PRICE_NAME")
    private String salePriceName;

    @Column(name = "APP_NAME")
    private String appName;

    @Column (name = "APP_ID")
    private String appId;

    @Column(name = "ICON_URL")
    private String iconUrl;

    @Column(name = "TYPE")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashName() {
        return hashName;
    }

    public void setHashName(String hashName) {
        this.hashName = hashName;
    }

    public String getSellPriceText() {
        return sellPriceText;
    }

    public void setSellPriceText(String sellPriceText) {
        this.sellPriceText = sellPriceText;
    }

    public String getSalePriceName() {
        return salePriceName;
    }

    public void setSalePriceName(String salePriceName) {
        this.salePriceName = salePriceName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
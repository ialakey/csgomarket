package com.alakey.csgomarket.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "CSGOMARKET_CASE")
@Entity(name = "csgomarket_Case")
@NamePattern("%s|id")
public class Case extends StandardEntity {
    private static final long serialVersionUID = -7230430523252185482L;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

//    @ManyToMany
//    @JoinTable(name = "CASE_FILE_DESCRIPTOR_LINK",
//            joinColumns = @JoinColumn(name = "CASE_ID"),
//            inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
//    private FileDescriptor image;

    @Column(name = "PRICE", nullable = false, precision = 20, scale = 2)
    private BigDecimal price;

    @Column(name = "COUNT")
    private Integer count;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private List<Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public FileDescriptor getImage() {
//        return image;
//    }
//
//    public void setImage(FileDescriptor image) {
//        this.image = image;
//    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
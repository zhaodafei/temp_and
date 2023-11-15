package com.fei.myfei.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BookInfo")
public class BookInfo {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name; // 图书名字
    private String author; // 作者
    private String address; // 地址
    private String price; // 价格

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", address='" + address + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

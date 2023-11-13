package com.fei.myfei.entity;

public class UserFei {

    public int id; // 主键序号
    public String name; // 姓名
    // public int age;
    // public long height;
    // public float weight;
    // public boolean agree; // 是否同意

    public UserFei() {

    }

    public UserFei(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserFei{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

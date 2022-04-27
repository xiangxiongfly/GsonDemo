package com.example.lib_java.bean;

import java.math.BigDecimal;

public class Person {
    public long id;
    public String name;
    public int age;
    public boolean sex;
    public float height;
    public double price;
    public String description;
    public BigDecimal length;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", length=" + length +
                '}';
    }
}

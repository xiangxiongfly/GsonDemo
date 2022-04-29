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

    public Person() {
        System.out.println("无参构造函数");
    }

    public Person(long id, String name, int age, boolean sex, float height, double price, String description, BigDecimal length) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.price = price;
        this.description = description;
        this.length = length;
        System.out.println("有参构造函数");
    }

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

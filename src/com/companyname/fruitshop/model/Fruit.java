package com.companyname.fruitshop.model;

public final class Fruit {
    private final String name;
    private final int count;

    public Fruit(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}

package model;

public class Product {
    private String name;
    private int count;

    public Product(String productName, int productCount) {
        this.count = productCount;
        this.name = productName;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }
}

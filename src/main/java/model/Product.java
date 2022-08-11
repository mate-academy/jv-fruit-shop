package model;

import java.math.BigDecimal;

public class Product {
    private String productName;
    private int productCount;

    public Product(String productName, int productCount) {
        this.productCount = productCount;
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

package core.basesyntax;

import java.time.LocalDate;

public class ProductBox {
    private String productName;
    private int count;
    private LocalDate expirationDate;

    public ProductBox(String productName, int count, LocalDate expirationDate) {
        this.productName = productName;
        this.count = count;
        this.expirationDate = expirationDate;
    }

    public String getProductName() {
        return productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}

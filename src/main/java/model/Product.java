package model;

public class Product {
    private static final String FORMAT = "%s,%s";
    private String name;
    private int count;

    public Product(String name, int count) {
        this.count = count;
        this.name = name;
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

    @Override
    public boolean equals(Object product) {
        if (product == this) {
            return true;
        }
        if (product == null) {
            return false;
        }
        if (product.getClass().equals(Product.class)) {
            Product product1 = (Product) product;
            return this.name.equals(product1.name) && this.count == product1.count;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 13;
        result = 71 * result + count;
        result = 71 * result + (this.name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, name, count);
    }
}

package core.basesyntax.service;

public class Product implements Comparable<Product> {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Product product) {
        return name.compareTo(product.getName());
    }
}

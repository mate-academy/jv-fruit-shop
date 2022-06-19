package core.basesyntax.model;

import java.util.Objects;

public class Product {
    private String type;

    public Product(String type) {
        this.type = type.equals("") ? "NoTypeProduct" : type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.equals("") ? "NoTypeProduct" : type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}

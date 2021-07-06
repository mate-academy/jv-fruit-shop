package core.basesyntax.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Fruit {
    private String name;
    private BigDecimal price;

    public Fruit(String name) {
        this.name = name;
    }

    public Fruit(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name) && Objects
            .equals(price, fruit.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Fruit{"
            + "name='" + name + '\''
            + ", price=" + price + '}';
    }
}

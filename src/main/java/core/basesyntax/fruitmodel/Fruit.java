package core.basesyntax.fruitmodel;

import java.util.Objects;

public class Fruit {
    private String name;
    private Integer quantity;

    public Fruit(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        return Objects.equals(name, fruit.name)
                && Objects.equals(quantity, fruit.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }
}

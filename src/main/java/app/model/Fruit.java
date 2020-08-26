package app.model;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit {
    private String name;
    private int quantity;
    private LocalDate endOfShelfLife;

    public Fruit(String name, int quantity, LocalDate endOfShelfLife) {
        this.name = name;
        this.quantity = quantity;
        this.endOfShelfLife = endOfShelfLife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fruit)) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return getQuantity() == fruit.getQuantity()
                && Objects.equals(getName(), fruit.getName())
                && Objects.equals(getEndOfShelfLife(), fruit.getEndOfShelfLife());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantity(), getEndOfShelfLife());
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getEndOfShelfLife() {
        return endOfShelfLife;
    }

}

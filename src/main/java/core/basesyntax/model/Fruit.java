package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit implements Cloneable {
    private String name;
    private int quantity;
    private LocalDate shelfLife;

    public Fruit(String name, int quantity, LocalDate shelfLife) {
        this.name = name;
        this.quantity = quantity;
        this.shelfLife = shelfLife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(LocalDate shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public Fruit clone() {
        return new Fruit(name, quantity, shelfLife);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return quantity == fruit.quantity &&
                Objects.equals(name, fruit.name) &&
                Objects.equals(shelfLife, fruit.shelfLife);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, shelfLife);
    }

    @Override
    public String toString() {
        return name + "," + quantity;
    }
}

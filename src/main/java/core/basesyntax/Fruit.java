package core.basesyntax;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit {

    private int quantity;
    private String name;
    private LocalDate expirationDate;

    public Fruit(int countOfFruits, String nameOfFruit, LocalDate dateOfShelfLife) {
        this.quantity = countOfFruits;
        this.name = nameOfFruit;
        this.expirationDate = dateOfShelfLife;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
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
        return quantity == fruit.quantity
                && Objects.equals(name, fruit.name)
                && Objects.equals(expirationDate, fruit.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, name, expirationDate);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "quantity=" + quantity
                + ", name='" + name + '\''
                + ", expirationDate=" + expirationDate + '}';
    }
}

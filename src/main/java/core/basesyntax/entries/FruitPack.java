package core.basesyntax.entries;

import java.time.LocalDate;
import java.util.Objects;

public class FruitPack implements Comparable {
    private String name;
    private int quantity;
    private LocalDate expirationDate;

    public FruitPack(String name, int quantity, LocalDate expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public int compareTo(Object o) {
        FruitPack fruitPack = (FruitPack) o;
        return expirationDate.compareTo(fruitPack.expirationDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitPack fruitPack = (FruitPack) o;
        return quantity == fruitPack.quantity
                && Objects.equals(name, fruitPack.name)
                && Objects.equals(expirationDate, fruitPack.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, expirationDate);
    }
}

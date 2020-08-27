package core.basesyntax.products;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit {
    private String name;
    private int amount;
    private LocalDate expirationDate;

    public Fruit() {
    }

    public Fruit(String name, int amount, LocalDate dateExpiration) {
        this.name = name;
        this.amount = amount;
        this.expirationDate = dateExpiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fruit fruit = (Fruit) obj;
        return amount == fruit.amount
                && Objects.equals(name, fruit.name)
                && Objects.equals(expirationDate, fruit.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, expirationDate);
    }
}

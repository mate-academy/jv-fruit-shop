package core.basesyntax.products;

import java.time.LocalDate;

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
}



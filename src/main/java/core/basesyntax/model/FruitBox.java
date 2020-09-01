package core.basesyntax.model;

import java.time.LocalDate;

public class FruitBox {
    private final String name;
    private Integer amount;
    private final LocalDate expiryDate;

    public FruitBox(String name, Integer amount, LocalDate expiryDate) {
        this.name = name;
        this.amount = amount;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public final class Fruit {
    public Integer amount;
    private final String name;
    private final LocalDate expDate;

    public Fruit(String name, LocalDate expDate, Integer amount) {
        this.name = name;
        this.expDate = expDate;
        this.amount = amount;

    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public String getName() {
        return name;
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
                && Objects.equals(expDate, fruit.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expDate, amount);
    }
}

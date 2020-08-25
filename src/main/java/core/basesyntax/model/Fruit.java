package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Fruit {
    private LocalDate exDate;

    public Fruit(LocalDate exDate) {
        this.exDate = exDate;
    }

    public LocalDate getExDate() {
        return exDate;
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
        return Objects.equals(exDate, fruit.exDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exDate);
    }
}

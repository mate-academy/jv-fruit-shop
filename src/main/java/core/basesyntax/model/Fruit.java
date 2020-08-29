package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit {
    private String name;
    private LocalDate expirationDate;

    public Fruit(String name, LocalDate expirationDate) {
        this.name = name;
        this.expirationDate = expirationDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
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
                && Objects.equals(expirationDate, fruit.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expirationDate);
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "name='" + name + '\''
                + ", expirationDate=" + expirationDate
                + '}';
    }
}

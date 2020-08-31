package core.basesyntax.identities;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit {
    private String type;
    private LocalDate dateOfProduction;

    public Fruit() {
    }

    public Fruit(String type, LocalDate dateOfProduction) {
        this.type = type;
        this.dateOfProduction = dateOfProduction;
    }

    public String getType() {
        return type;
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
        return Objects.equals(type, fruit.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, dateOfProduction);
    }
}

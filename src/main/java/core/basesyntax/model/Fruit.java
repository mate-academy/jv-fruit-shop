package core.basesyntax.model;

import java.time.LocalDate;
import java.util.Objects;

public class Fruit implements Cloneable {
    private String name;
    private LocalDate shelfLife;

    public Fruit(String name, LocalDate shelfLife) {
        this.name = name;
        this.shelfLife = shelfLife;
    }

    public String getName() {
        return name;
    }

    public LocalDate getShelfLife() {
        return shelfLife;
    }

    @Override
    public Fruit clone() {
        return new Fruit(name, shelfLife);
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
                && Objects.equals(shelfLife, fruit.shelfLife);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, shelfLife);
    }
}

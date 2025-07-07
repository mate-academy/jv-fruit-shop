package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;
    private int amount;

    public Fruit(String name, int amount) {
        this.name = name;
        this.amount = amount;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Fruit fruit)) {
            return false;
        }
        return Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

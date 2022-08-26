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
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 17 * result + amount;
        return result;
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
        if (amount != fruit.amount) {
            return false;
        }
        return Objects.equals(name, fruit.name)
                && Objects.equals(amount, fruit.amount);
    }
}

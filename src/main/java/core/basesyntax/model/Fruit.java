package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private Integer amount;
    private String name;

    public Fruit() {
    }

    public Fruit(String name, Integer balance) {
        this.name = name;
        this.amount = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer balance) {
        this.amount = balance;
    }

    @Override
    public String toString() {
        return name + "," + amount.toString() + System.lineSeparator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fruit plant = (Fruit) o;
        return name.equals(plant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

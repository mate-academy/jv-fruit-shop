package core.basesyntax.model.objects;

import java.util.Objects;

public class Plant {
    protected String name;
    protected Integer balance;

    public Plant() {
    }

    public Plant(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return name + "," + balance.toString() + System.lineSeparator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Plant plant = (Plant) o;
        return name.equals(plant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;
    private Integer balance;

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
        return "Fruit{"
                + "name='" + name + '\''
                + ", balance=" + balance
                + '}';
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
        return name.equals(fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

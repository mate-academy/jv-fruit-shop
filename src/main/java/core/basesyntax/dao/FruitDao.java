package core.basesyntax.dao;

import java.util.Objects;

public class FruitDao {
    private String name;
    private int quantity;

    public FruitDao(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot add negative quantity.");
        }
        this.quantity += amount;
    }

    public void subtractQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot subtract negative quantity.");
        }
        if (this.quantity < amount) {
            throw new IllegalStateException("Not enough quantity to subtract.");
        }
        this.quantity -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o != null && getClass() == o.getClass()) {
                FruitDao fruitsDao = (FruitDao) o;
                return Objects.equals(name, fruitsDao.name);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "FruitDao{"
                + "name='"
                + name
                + '\''
                + ", quantity="
                + quantity
                + '}';
    }
}

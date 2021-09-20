package model;

import java.util.Objects;

public class FruitRecord {
   private OperationType type;
   private Fruit fruit;
   private int amount;

    public FruitRecord(OperationType type, Fruit fruit, int amount) {
        this.type = type;
        this.fruit = fruit;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public OperationType getType() {
        return type;
    }

    public Fruit getFruit() {
        return fruit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FruitRecord that = (FruitRecord) o;
        return amount == that.amount && type == that.type && Objects.equals(fruit, that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, fruit, amount);
    }

    @Override
    public String toString() {
        return "FruitRecord{" +
                "type=" + type +
                ", fruit=" + fruit +
                ", amount=" + amount +
                '}';
    }
}

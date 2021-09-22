package core.model;

import java.util.Objects;

public class FruitRecord<T> {
    private String operationType;
    private String fruit;
    private int amount;

    public FruitRecord() {
    }

    public FruitRecord(String fruit, int amount) {
        this.fruit = fruit;
        this.amount = amount;
    }

    public FruitRecord(String operationType, String fruit, int amount) {
        this.operationType = operationType;
        this.fruit = fruit;
        this.amount = amount;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FruitRecord<?> that = (FruitRecord<?>) o;
        return fruit.equals(that.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit);
    }

    @Override
    public String toString() {
        return "FruitRecord{"
                + "fruit='" + fruit + '\''
                + ", amount=" + amount
                + '}';
    }
}

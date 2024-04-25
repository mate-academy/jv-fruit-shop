package model;

public class FruitTransaction {
    private final FruitOperationType fruitOperationType;
    private final String string;
    private Integer value;

    public FruitTransaction(FruitOperationType fruitOperationType,
                            String string, Integer value) {
        this.fruitOperationType = fruitOperationType;
        this.string = string;
        this.value = value;
    }

    public String getFruitType() {
        return string;
    }

    public FruitOperationType getOperationType() {
        return fruitOperationType;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public java.lang.String toString() {
        return "Fruit{"
                + "operationType=" + fruitOperationType
                + ", fruitType=" + string
                + ", value="
                + value
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

        FruitTransaction fruitTransaction = (FruitTransaction) o;

        return string == fruitTransaction.string;
    }

    @Override
    public int hashCode() {
        return string != null ? string.hashCode() : 0;
    }
}

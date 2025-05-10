package model;

public class FruitTransaction {
    private final FruitOperationType fruitOperationType;
    private final String fruitName;
    private Integer value;

    public FruitTransaction(FruitOperationType fruitOperationType,
                            String fruitName, Integer value) {
        this.fruitOperationType = fruitOperationType;
        this.fruitName = fruitName;
        this.value = value;
    }

    public String getFruitType() {
        return fruitName;
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
                + ", fruitType=" + fruitName
                + ", value="
                + value
                + '}';
    }
}

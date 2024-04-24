package model;

public class FruitOperation {
    private FruitOperationType fruitOperationType;
    private FruitType fruitType;
    private Integer value;

    public FruitOperation(FruitOperationType fruitOperationType,
                          FruitType fruitType, Integer value) {
        this.fruitOperationType = fruitOperationType;
        this.fruitType = fruitType;
        this.value = value;
    }

    public FruitType getFruitType() {
        return fruitType;
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
    public String toString() {
        return "Fruit{"
                + "operationType=" + fruitOperationType
                + ", fruitType=" + fruitType
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

        FruitOperation fruitOperation = (FruitOperation) o;

        return fruitType == fruitOperation.fruitType;
    }

    @Override
    public int hashCode() {
        return fruitType != null ? fruitType.hashCode() : 0;
    }
}

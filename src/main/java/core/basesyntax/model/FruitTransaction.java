package core.basesyntax.model;

public class FruitTransaction {
    private String fruitType;
    private int operationValue;

    public FruitTransaction(String fruitType, int operationValue) {
        this.fruitType = fruitType;
        this.operationValue = operationValue;
    }

    public String getFruitType() {
        return fruitType;
    }

    public int getOperationValue() {
        return operationValue;
    }
}

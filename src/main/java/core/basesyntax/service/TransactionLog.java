package core.basesyntax.service;

public class TransactionLog {
    private final String typeOfOperation;
    private final String fruitName;
    private final int fruitQuantity;

    public TransactionLog(String operationType, String fruitName, int fruitQuantity) {
        this.typeOfOperation = operationType;
        this.fruitName = fruitName;
        this.fruitQuantity = fruitQuantity;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }
}

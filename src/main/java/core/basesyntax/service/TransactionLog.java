package core.basesyntax.service;

public class TransactionLog {
    private String typeOfOperation;
    private String fruitName;
    private int fruitQuantity;

    public TransactionLog(String operationType, String fruitName, int fruitQuantity) {
        this.typeOfOperation = operationType;
        this.fruitName = fruitName;
        this.fruitQuantity = fruitQuantity;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitQuantity() {
        return fruitQuantity;
    }

    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }
}

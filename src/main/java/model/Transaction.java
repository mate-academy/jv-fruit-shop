package model;

import service.SeparatorService;
import service.impl.SeparatorServiceImpl;
import strategy.OperationHandler;

public class Transaction {
    private int value;
    private String fruit;
    private OperationHandler operationHandler;

    public void createTransaction(String line) {
        SeparatorService separator = new SeparatorServiceImpl(line);
        setFruitOperation(separator.getOperationFromLine());
        setFruit(separator.getFruitFromLine());
        setValue(separator.getValueFromLine());
    }

    public int getFruitValue() {
        return value;
    }

    public String getFruitName() {
        return fruit;
    }

    public OperationHandler getFruitOperationType() {
        return operationHandler;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public void setFruitOperation(OperationHandler operationHandler) {
        this.operationHandler = operationHandler;
    }
}

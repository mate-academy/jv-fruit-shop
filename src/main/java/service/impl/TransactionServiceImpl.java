package service.impl;

import strategy.OperationHandler;
import service.OperationService;
import service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
    private static final int ZERO_INDEX = 0;
    private static final int ONE_INDEX = 1;
    private static final int TWO_INDEX = 2;
    private static final String SEPARATOR = ",";
    private int value;
    private String fruit;
    private OperationHandler operationHandler;

    @Override
    public void createTransaction(String line) {
        setFruitOperation(getOperationFromLine(line));
        setFruit(getFruitFromLine(line));
        setValue(getValueFromLine(line));
    }

    @Override
    public int getFruitValue() {
        return value;
    }

    @Override
    public String getFruitName() {
        return fruit;
    }

    @Override
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

    private OperationHandler getOperationFromLine(String line) {
        String operationSymbol = line.split(SEPARATOR)[ZERO_INDEX];
        OperationService operationService = new OperationServiceImpl();
        return operationService.createOperation(operationSymbol);
    }

    private String getFruitFromLine(String line) {
        return line.split(SEPARATOR)[ONE_INDEX];
    }

    private int getValueFromLine(String line) {
        return Integer.parseInt(line.split(SEPARATOR)[TWO_INDEX]);
    }
}

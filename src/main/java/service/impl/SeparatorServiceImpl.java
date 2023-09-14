package service.impl;

import service.OperationService;
import service.SeparatorService;
import strategy.OperationHandler;

public class SeparatorServiceImpl implements SeparatorService {
    private static final int ZERO_INDEX = 0;
    private static final int ONE_INDEX = 1;
    private static final int TWO_INDEX = 2;
    private static final String SEPARATOR = ",";
    private String lineToSeparate;

    public SeparatorServiceImpl(String lineToSeparate) {
        this.lineToSeparate = lineToSeparate;
    }

    @Override
    public OperationHandler getOperationFromLine() {
        String operationSymbol = lineToSeparate.split(SEPARATOR)[ZERO_INDEX];
        OperationService operationService = new OperationServiceImpl();
        return operationService.createOperation(operationSymbol);
    }

    @Override
    public String getFruitFromLine() {
        return lineToSeparate.split(SEPARATOR)[ONE_INDEX];
    }

    @Override
    public int getValueFromLine() {
        return Integer.parseInt(lineToSeparate.split(SEPARATOR)[TWO_INDEX]);
    }
}

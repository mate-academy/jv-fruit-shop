package service;

import strategy.OperationHandler;

public interface SeparatorService {

    OperationHandler getOperationFromLine();

    String getFruitFromLine();

    int getValueFromLine();
}

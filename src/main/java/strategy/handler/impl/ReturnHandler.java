package strategy.handler.impl;

import model.FruitTransaction;
import strategy.handler.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public FruitTransaction getOperationResult(FruitTransaction fruitTransaction) {
        return fruitTransaction;
    }
}

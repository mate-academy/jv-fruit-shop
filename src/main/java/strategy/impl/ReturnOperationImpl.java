package strategy.impl;

import model.FruitTransaction;
import strategy.OperationHandler;

public class ReturnOperationImpl implements OperationHandler {
    @Override
    public int operationHandler(FruitTransaction transaction, int storeQuantity) {
        return storeQuantity + transaction.getQuantity();
    }
}

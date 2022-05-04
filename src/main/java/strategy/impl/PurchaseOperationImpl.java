package strategy.impl;

import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationImpl implements OperationHandler {
    @Override
    public int operationHandler(FruitTransaction transaction, int storeQuantity) {
        if (storeQuantity >= transaction.getQuantity()) {
            return storeQuantity - transaction.getQuantity();
        } else {
            throw new RuntimeException("We don't have " + transaction.getQuantity() + " "
                    + transaction.getFruit());
        }
    }
}

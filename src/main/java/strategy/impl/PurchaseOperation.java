package strategy.impl;

import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int getOperation(FruitTransaction data, int amount) {
        if (data == null) {
            throw new RuntimeException(
                    "Data cannot be null");
        }
        int newAmount = amount - data.getQuantity();
        if (newAmount < 0) {
            throw new RuntimeException(
                    "Purchase would make balance negative for fruit: " + data.getFruit());
        }
        return amount - data.getQuantity();
    }
}

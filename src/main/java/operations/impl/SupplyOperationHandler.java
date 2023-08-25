package operations.impl;

import db.Storage;
import model.FruitTransaction;
import operations.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void execute(FruitTransaction fruitTransaction) {
        Storage.addFruits(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
    }
}

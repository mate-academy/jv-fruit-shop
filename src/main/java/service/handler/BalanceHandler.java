package service.handler;

import db.Storage;
import model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Storage.of(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}

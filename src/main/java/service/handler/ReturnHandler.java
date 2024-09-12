package service.handler;

import db.Storage;
import model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Storage.of(fruitTransaction.getFruit(),
                Storage.getQuantity(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}

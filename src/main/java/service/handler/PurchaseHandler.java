package service.handler;

import java.util.Map;

import db.Storage;
import model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Storage.of(fruitTransaction.getFruit(),
                Storage.getQuantity(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}

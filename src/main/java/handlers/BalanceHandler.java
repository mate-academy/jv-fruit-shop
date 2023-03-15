package handlers;

import db.Storage;
import model.FruitTransaction;

public class BalanceHandler implements OperationTypeHandler {

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

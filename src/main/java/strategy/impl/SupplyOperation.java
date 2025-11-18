package strategy.impl;

import db.Storage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Integer fruitStock = Storage.getQuantity(transaction.getFruit());
        Storage.put(transaction.getFruit(), transaction.getQuantity() + fruitStock);
    }
}

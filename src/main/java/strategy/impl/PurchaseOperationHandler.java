package strategy.impl;

import db.FruitStorage;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int oldQuantity = FruitStorage.fruits.get(transaction.getFruit());
        int newQuantity = oldQuantity - transaction.getQuantity();
        FruitStorage.fruits.put(transaction.getFruit(), newQuantity);
    }
}

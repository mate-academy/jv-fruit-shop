package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int boughtQuantity = transaction.getQuantity();
        int currentQuantity = Storage.getFruitQuantity(fruit);
        int newQuantity = currentQuantity - boughtQuantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough " + fruit + " in storage. We have: "
                    + currentQuantity + " but tried to buy: " + boughtQuantity);
        }
        Storage.putFruit(fruit, newQuantity);
    }
}

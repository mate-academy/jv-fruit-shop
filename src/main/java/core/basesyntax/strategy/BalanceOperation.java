package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;


public class BalanceOperation implements OperationHandler{


    @Override
    public void handle(Storage storage, FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        Storage.fruits.put(fruit, quantity);
    }
}

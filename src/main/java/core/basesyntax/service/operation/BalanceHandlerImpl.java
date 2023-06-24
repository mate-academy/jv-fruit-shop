package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandlerImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, Storage.fruits.get(fruit) + fruitTransaction.getQuantity());
        } else {
            Storage.fruits.put(fruit, fruitTransaction.getQuantity());
        }
    }
}

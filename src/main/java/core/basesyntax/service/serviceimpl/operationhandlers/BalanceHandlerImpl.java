package core.basesyntax.service.serviceimpl.operationhandlers;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;

public class BalanceHandlerImpl implements OperationHandler {

    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        if (Storage.fruitsAndAmount.containsKey(fruit)) {
            Storage.fruitsAndAmount.put(
                    fruit, Storage.fruitsAndAmount.get(fruit) + fruitTransaction.getQuantity());
        } else {
            Storage.fruitsAndAmount.put(fruit, fruitTransaction.getQuantity());
        }
    }
}

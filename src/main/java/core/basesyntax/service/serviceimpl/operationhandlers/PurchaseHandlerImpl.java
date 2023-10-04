package core.basesyntax.service.serviceimpl.operationhandlers;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FruitTransaction;

public class PurchaseHandlerImpl implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer amount = fruitTransaction.getQuantity();
        if (Storage.fruitsAndAmount.get(fruit) >= amount) {
            Storage.fruitsAndAmount.put(fruit, Storage.fruitsAndAmount.get(fruit) - amount);
        } else {
            throw new RuntimeException(
                    "not enough fruits to purchase in the Storage");
        }
    }
}

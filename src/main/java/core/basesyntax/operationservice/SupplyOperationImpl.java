package core.basesyntax.operationservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class SupplyOperationImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        int currentAmount = Storage.getQuantity(fruit);
        Storage.putFruit(fruit, currentAmount + quantity);

    }
}

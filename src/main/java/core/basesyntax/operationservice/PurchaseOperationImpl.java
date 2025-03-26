package core.basesyntax.operationservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        int currentAmount = Storage.getQuantity(fruit);

        if (currentAmount < quantity) {
            throw new RuntimeException(String.format(
                    "Error: Not enough %s in storage! Required: %d, \n"
                            +
                            "available: %d",
                    fruit, quantity, currentAmount
            ));
        }

        Storage.putFruit(fruit, currentAmount - quantity);
    }
}

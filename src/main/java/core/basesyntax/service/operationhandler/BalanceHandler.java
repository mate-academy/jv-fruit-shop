package core.basesyntax.service.operationhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction, Storage storage) {
        if (transaction == null) {
            System.out.println("Balance operation requires a valid transaction.");
            return;
        }

        String fruitType = transaction.getFruit();
        int currentQuantity = storage.fruits.getOrDefault(fruitType, 0);
        int newQuantity = transaction.getQuantity() + currentQuantity;

        storage.fruits.put(fruitType, newQuantity);

        System.out.println("Balance operation successful for " + fruitType
                + ". New quantity: " + newQuantity);
    }
}

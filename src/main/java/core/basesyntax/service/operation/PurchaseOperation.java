package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(String fruitName, int amount) {
        int currentAmount = Storage.get(fruitName);
        if (currentAmount < amount) {
            throw new RuntimeException(
                    "Not enough %s on balance to make this purchase.".formatted(fruitName));
        }
        int newAmount = currentAmount - amount;
        Storage.save(fruitName, newAmount);
    }
}

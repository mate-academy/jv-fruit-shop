package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(String fruitName, int amount) {
        int currentAmount = Storage.get(fruitName);
        int newAmount = currentAmount + amount;
        Storage.save(fruitName, newAmount);
    }
}

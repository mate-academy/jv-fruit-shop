package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(Transaction transaction) {
        Fruit fruit = transaction.getProduct();
        int amount = Storage.fruits.getOrDefault(fruit, 0);
        int purchaseAmount = transaction.getQuantity();
        if (purchaseAmount <= amount) {
            Storage.fruits.put(fruit,
                    Storage.fruits.getOrDefault(fruit, 0) - transaction.getQuantity());
        } else {
            throw new RuntimeException("Error! Can't purchase required amount of " + fruit);
        }
    }
}

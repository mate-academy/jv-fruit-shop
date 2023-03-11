package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionLine;

public class BalansOperationHandler implements OperationHandler {
    @Override
    public void operation(TransactionLine transactionLine) {
        String fruitName = transactionLine.getFruitName();
        int quantity = transactionLine.getQuantity();
        Storage.storage.put(new Fruit(fruitName), quantity);
    }
}

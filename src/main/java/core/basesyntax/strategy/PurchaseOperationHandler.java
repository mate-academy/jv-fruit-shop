package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int quantity = transactionDto.getQuantity();
        int oldQuantity = Storage.storage.get(fruit);
        if (quantity > oldQuantity) {
            throw new RuntimeException("There are not so many fruits in the store.");
        }
        quantity = oldQuantity - quantity;
        Storage.storage.put(fruit, quantity);
    }
}

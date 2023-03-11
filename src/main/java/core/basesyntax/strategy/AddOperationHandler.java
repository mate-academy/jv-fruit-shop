package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int quantity = transactionDto.getQuantity();
        if (Storage.storage.get(fruit) != null) {
            int oldQuantity = Storage.storage.get(fruit);
            quantity += oldQuantity;
        }
        Storage.storage.put(fruit, quantity);
    }
}

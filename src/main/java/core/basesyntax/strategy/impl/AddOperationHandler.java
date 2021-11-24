package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationHandler;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int oldQuantity = Storage.storage.getOrDefault(Storage.storage.get(fruit),0);
        int quantity = transactionDto.getQuantity() + oldQuantity;
        Storage.storage.put(fruit, quantity);
    }
}

package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationHandler;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int oldQuantity = Storage.storage.get(fruit) == null ? 0 : Storage.storage.get(fruit);
        int quantity = transactionDto.getQuantity() + oldQuantity;
        Storage.storage.put(fruit, quantity);
    }
}

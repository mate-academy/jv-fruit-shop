package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int oldQuantity = Storage.storage.get(fruit) == null ? 0 : Storage.storage.get(fruit);
        int quantity = oldQuantity - transactionDto.getQuantity();
        if (quantity < 0) {
            throw new OperationHandlerException("Not enough fruits to buy");
        }
        Storage.storage.put(fruit, quantity);
    }
}

package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int oldQuantity = Storage.fruits.get(fruit) == null ? 0 : Storage.fruits.get(fruit);
        int quantity = oldQuantity - transactionDto.getQuantity();
        if (quantity < 0) {
            throw new PurchaseOperationHandlerException("Not enough fruits to buy");
        }
        Storage.fruits.put(fruit, quantity);
    }
}

package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class AddOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int oldQuantity = Storage.fruits.get(fruit) == null ? 0 : Storage.fruits.get(fruit);
        int quantity = transactionDto.getQuantity() + oldQuantity;
        Storage.fruits.put(fruit, quantity);
    }
}

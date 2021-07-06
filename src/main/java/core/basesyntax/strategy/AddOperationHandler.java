package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class AddOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int resultingQuantity = Storage.storage
                .getOrDefault(fruit, 0) + transactionDto.getQuantity();
        Storage.storage.put(fruit, resultingQuantity);
        return resultingQuantity;
    }
}

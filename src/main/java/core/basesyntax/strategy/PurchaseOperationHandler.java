package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int currentQuantity = Storage.storage.getOrDefault(fruit, 0);
        int subtractQuantity = transactionDto.getQuantity();
        if (currentQuantity - subtractQuantity < 0) {
            throw new RuntimeException("Could not purchase! We don't have enough fruit["
                    + fruit.getName() + "] in our storage!\n"
                    + "Quantity left in storage - " + currentQuantity
                    + "\nQuantity needed to buy - " + subtractQuantity);
        }
        return Storage.storage.put(fruit, currentQuantity - subtractQuantity);
    }
}

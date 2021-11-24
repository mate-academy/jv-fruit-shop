package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruit());
        Integer quantity = transactionDto.getQuantity();
        Integer oldQuantity = Storage.getStorage().get(fruit);
        if (oldQuantity < quantity) {
            throw new RuntimeException("Not enough" + transactionDto.getFruit());
        }
        oldQuantity -= quantity;
        Storage.add(fruit, oldQuantity);
    }
}

package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class SupplyAndReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruit());
        Integer quantity = transactionDto.getQuantity();
        Integer oldQuantity = Storage.storage.get(fruit);
        quantity += oldQuantity;
        Storage.storage.put(fruit, quantity);
    }
}

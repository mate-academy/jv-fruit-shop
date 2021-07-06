package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        int quantity = transactionDto.getQuantity();
        Storage.storage.put(new Fruit(transactionDto.getName()), quantity);
        return quantity;
    }
}

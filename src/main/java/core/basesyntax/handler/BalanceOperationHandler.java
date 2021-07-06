package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Storage.fruitStorage.put(new Fruit(transactionDto.getName()), transactionDto.getQuantity());
        return transactionDto.getQuantity();
    }
}

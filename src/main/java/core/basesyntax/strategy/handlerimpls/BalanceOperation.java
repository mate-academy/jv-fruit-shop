package core.basesyntax.strategy.handlerimpls;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public boolean apply(TransactionDto transactionDto) {
        int currentQuantity = transactionDto.getQuantity();
        Storage.storage.put(new Fruit(transactionDto.getName()), currentQuantity);
        return true;
    }
}

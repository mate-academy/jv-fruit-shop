package core.basesyntax.strategy.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.handler.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Storage.storage.put(transactionDto.getFruitName(), transactionDto.getQuantity());
    }
}

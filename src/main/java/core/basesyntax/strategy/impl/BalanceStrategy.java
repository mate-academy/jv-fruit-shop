package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceStrategy implements OperationStrategy {

    @Override
    public void apply(TransactionDto transactionDto) {
        if (transactionDto.getFruit() == null || transactionDto.getQuantity() == null) {
            throw new RuntimeException("Invalid data");
        }
        Storage.getFruitsStorage().put(transactionDto.getFruit(), transactionDto.getQuantity());
    }
}

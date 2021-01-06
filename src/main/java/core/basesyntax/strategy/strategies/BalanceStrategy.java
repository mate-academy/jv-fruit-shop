package core.basesyntax.strategy.strategies;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Storage.storage.put(transactionDto.getFruit(), transactionDto.getQuantity());
    }
}

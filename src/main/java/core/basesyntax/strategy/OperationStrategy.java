package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;

public interface OperationStrategy {
    void operate(TransactionDto transactionDto);
}

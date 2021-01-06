package core.basesyntax.stratege;

import core.basesyntax.model.TransactionDto;

public interface OperationStrategy {
    void doOperation(TransactionDto transactionDto);
}

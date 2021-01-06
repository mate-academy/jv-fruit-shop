package core.basesyntax.strategy;

import core.basesyntax.model.TransactionDto;

public interface OperationStrategy {

    void apply(TransactionDto transactionObject);
}

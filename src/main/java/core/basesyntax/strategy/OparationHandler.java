package core.basesyntax.strategy;

import core.basesyntax.models.TransactionDto;

public interface OparationHandler {
    void apply(TransactionDto transactionDto);
}

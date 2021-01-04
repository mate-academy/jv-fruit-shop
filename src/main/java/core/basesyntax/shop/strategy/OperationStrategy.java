package core.basesyntax.shop.strategy;

import core.basesyntax.shop.model.TransactionDto;

public interface OperationStrategy {
    void apply(TransactionDto transactionDto);
}

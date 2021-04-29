package core.basesyntax.service;

import core.basesyntax.model.dto.TransactionDto;

public interface OperationStrategy {
    void apply(TransactionDto transactionDto);
}

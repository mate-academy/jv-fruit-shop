package core.basesyntax.operations;

import core.basesyntax.model.TransactionDto;

public interface Operation {
    void apply(TransactionDto transactionDto);
}

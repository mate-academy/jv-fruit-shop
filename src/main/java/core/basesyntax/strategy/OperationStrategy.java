package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public interface OperationStrategy {
    void apply(TransactionDto transactionDto, Storage storage);
}

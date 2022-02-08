package core.basesyntax.service.operations;

import core.basesyntax.model.TransactionDto;

public interface OperationHendler {
    void apply(TransactionDto fruitRecord);
}

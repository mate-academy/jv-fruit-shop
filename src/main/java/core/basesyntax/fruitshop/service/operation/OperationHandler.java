package core.basesyntax.fruitshop.service.operation;

import core.basesyntax.fruitshop.model.TransactionDto;

public interface OperationHandler {
    void applyOperation(TransactionDto transactionDto);
}

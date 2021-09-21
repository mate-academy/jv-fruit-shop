package core.basesyntax.operationstrategy;

import core.basesyntax.model.TransactionDto;

public interface OperationHandler {
    Integer doOperation(TransactionDto transactionDto);
}

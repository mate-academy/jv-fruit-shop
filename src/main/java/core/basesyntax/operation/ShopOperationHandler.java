package core.basesyntax.operation;

import core.basesyntax.model.TransactionDto;

public interface ShopOperationHandler {
    Integer getOperationResult(TransactionDto transactionDto);
}

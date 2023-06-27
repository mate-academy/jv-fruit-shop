package core.basesyntax.service.ftoperation;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionOperationStrategy {
    FruitTransactionOperationHandler getHandler(FruitTransaction.Operation operation);
}

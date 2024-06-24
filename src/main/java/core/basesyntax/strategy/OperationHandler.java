package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int MIN_QUANTITY = 0;
    void applyOperation(FruitTransaction transaction);

    default Integer getCurrentBalance(FruitTransaction transaction) {
        return Storage.reports.get(transaction.getFruitName());
    }
}

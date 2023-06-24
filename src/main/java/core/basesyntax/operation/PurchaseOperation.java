package core.basesyntax.operation;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        Storage.getFruitStorage().merge(
                transaction.getFruit(),
                transaction.getQuantity(),
                PurchaseOperation::purchaseOperation);
    }

    private static Integer purchaseOperation(Integer oldValue, Integer newValue) {
        int result = oldValue - newValue;
        if (result < 0) {
            throw new RuntimeException("Not enough fruit. The transaction could not be completed.");
        }
        return result;
    }
}

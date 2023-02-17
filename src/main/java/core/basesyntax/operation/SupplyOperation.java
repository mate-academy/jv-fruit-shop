package core.basesyntax.operation;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction transaction) {
        Storage.getFruitStorage().merge(
                transaction.getFruit(),
                transaction.getQuantity(),
                Integer::sum
        );
    }
}

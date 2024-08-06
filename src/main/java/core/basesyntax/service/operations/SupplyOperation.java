package core.basesyntax.service.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getAllFruits().merge(transaction.getFruit(), transaction.getQuantity(),
                Integer::sum);
    }
}

package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitRecord transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        int supplyQuantity = transaction.getQuantity();
        Storage.storage.merge(transaction.getFruit(), supplyQuantity, Integer::sum);
    }
}

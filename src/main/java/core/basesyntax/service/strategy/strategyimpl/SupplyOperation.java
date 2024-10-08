package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitRecord transaction) {
        int supplyQuantity = transaction.getQuantity();
        Storage.storage.merge(transaction.getFruit(), supplyQuantity, Integer::sum);
    }
}

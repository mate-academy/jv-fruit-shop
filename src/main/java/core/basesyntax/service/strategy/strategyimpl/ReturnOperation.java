package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitRecord transaction) {
        int returnFruits = transaction.getQuantity();
        Storage.storage.merge(transaction.getFruit(),returnFruits, Integer::sum);
    }
}

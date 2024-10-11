package core.basesyntax.service.strategy.strategyimpl;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitRecord;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitRecord transaction) {
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}

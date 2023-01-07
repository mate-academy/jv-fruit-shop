package core.basesyntax.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.operation.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void getOperationResult(FruitsTranslation fruitTransaction) {
        Storage.fruitsMap.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

package core.basesyntax.optration.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.optration.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public void getOperationResult(FruitsTranslation fruitTransaction) {
        Storage.fruitsMap.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

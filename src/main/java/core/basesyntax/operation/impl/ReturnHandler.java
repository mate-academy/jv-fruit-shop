package core.basesyntax.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitsTranslation;
import core.basesyntax.operation.OperationHandler;

public class ReturnHandler implements OperationHandler {

    @Override
    public void getOperationResult(FruitsTranslation fruitTransaction) {
        String resultFruits = fruitTransaction.getFruit();
        int currentQtyInStorage = Storage.fruitsMap.get(resultFruits);
        int returnQty = fruitTransaction.getQuantity();
        Storage.fruitsMap.put(resultFruits, (currentQtyInStorage + returnQty));
    }
}

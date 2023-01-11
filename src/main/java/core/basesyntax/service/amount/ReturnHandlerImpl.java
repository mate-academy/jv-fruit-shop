package core.basesyntax.service.amount;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandlerImpl implements OperationHandler {
    @Override
    public void updateAmountInStorage(FruitTransaction fruitTransaction) {
        Storage.fruitMap.put(fruitTransaction.getFruitType(),
                (Storage.fruitMap.get(fruitTransaction.getFruitType())
                        + fruitTransaction.getAmount()));
    }
}

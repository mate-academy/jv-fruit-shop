package core.basesyntax.service.amount;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandlerImpl implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruitType(),
                (Storage.fruits.get(fruitTransaction.getFruitType())
                        + fruitTransaction.getAmount()));
    }
}

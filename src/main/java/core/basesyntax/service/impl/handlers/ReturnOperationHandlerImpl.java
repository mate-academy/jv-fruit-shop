package core.basesyntax.service.impl.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {

    @Override
    public void operate(FruitTransaction fruitTransaction) {
        if (Storage.fruits.containsKey(fruitTransaction.getFruit())) {
            Storage.fruits.put(fruitTransaction.getFruit(),
                    Storage.fruits.get(fruitTransaction.getFruit())
                            + fruitTransaction.getQuantity());
        } else {
            Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}

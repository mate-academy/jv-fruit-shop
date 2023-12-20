package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        int oldQuantity = FruitStorage.fruitQuantities.get(transaction.getFruit());
        FruitStorage.fruitQuantities
                .put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}

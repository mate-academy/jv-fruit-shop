package core.basesyntax.strategy.handler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int fruitsBefore = FruitStorage.getStorage().get(transaction.getFruit());
        FruitStorage.getStorage()
                .put(transaction.getFruit(), fruitsBefore + transaction.getQuantity());
    }
}

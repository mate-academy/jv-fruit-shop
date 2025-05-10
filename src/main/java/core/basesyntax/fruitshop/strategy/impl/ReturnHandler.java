package core.basesyntax.fruitshop.strategy.impl;

import core.basesyntax.fruitshop.db.Storage;
import core.basesyntax.fruitshop.model.FruitTransaction;
import core.basesyntax.fruitshop.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getInstance().getFruitStorage().merge(transaction.getFruit(),
                transaction.getQuantity(), Integer::sum);
    }
}

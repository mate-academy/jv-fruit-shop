package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitShop;

public class ReturnOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        FruitShop.storage.put(transaction.getFruit(),
                FruitShop.storage.getOrDefault(transaction.getFruit(), 0)
                        + transaction.getQuantity());
    }
}

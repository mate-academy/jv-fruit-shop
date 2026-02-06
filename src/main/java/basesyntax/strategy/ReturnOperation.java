package basesyntax.strategy;

import basesyntax.db.Storage;
import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;

public class ReturnOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getFruits().put(
                transaction.getFruit(),
                Storage.getFruits().getOrDefault(transaction.getFruit(), 0)
                        + transaction.getQuantity()
        );
    }
}

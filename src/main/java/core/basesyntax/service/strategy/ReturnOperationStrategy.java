package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationStrategy implements OperationStrategy {
    @Override
    public void process(FruitTransaction transaction, Storage storage) {
        storage.updateFruitQuantity(transaction.getFruit(),
                storage.getFruitQuantity(transaction.getFruit()) + transaction.getQuantity());
    }
}

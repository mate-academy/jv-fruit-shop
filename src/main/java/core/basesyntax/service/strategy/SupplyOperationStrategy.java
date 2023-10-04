package core.basesyntax.service.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationStrategy implements OperationStrategy {
    private Storage storage;

    public SupplyOperationStrategy(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void process(FruitTransaction transaction) {
        storage.updateFruitQuantity(transaction.getFruit(),
                storage.getFruitQuantity(transaction.getFruit()) + transaction.getQuantity());
    }
}

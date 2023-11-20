package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class OperationPurchasePerformer implements OperationPerformer {
    @Override
    public void perform(FruitTransaction transaction, Storage storage) {
        storage.getFruits().compute(transaction.getFruit(),
                (key, val) -> val - transaction.getQuantity());
    }
}

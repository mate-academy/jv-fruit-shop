package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class OperationSupplyPerformer implements OperationPerformer {
    @Override
    public void perform(FruitTransaction transaction) {
        Storage.getFruits().compute(transaction.getFruit(),
                (key, val) -> val + transaction.getQuantity());
    }
}

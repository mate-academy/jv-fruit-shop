package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class OperationBalancePerformer implements OperationPerformer {
    @Override
    public void perform(FruitTransaction transaction, Storage storage) {
        storage.getFruits().put(transaction.getFruit(), transaction.getQuantity());
    }
}

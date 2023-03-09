package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class Balance implements CalculationService {
    @Override
    public void transaction(FruitTransaction transaction) {
        Storage.STORAGE.put(transaction.getFruit(), transaction.getQuantity());
    }
}

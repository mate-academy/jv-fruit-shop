package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class Purchase implements CalculationService {
    @Override
    public void calculateAndStore(FruitTransaction transaction) {
        int amount = Storage.STORAGE.get(transaction.getFruit())
                - transaction.getQuantity();
        Storage.STORAGE.put(transaction.getFruit(), amount);
    }
}

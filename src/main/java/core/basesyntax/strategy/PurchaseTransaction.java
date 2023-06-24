package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseTransaction implements CalculationService {
    @Override
    public void calculateAndStore(FruitTransaction transaction) {
        int amount = Storage.STORAGE.get(transaction.getFruit())
                - transaction.getQuantity();
        Storage.STORAGE.put(transaction.getFruit(), amount);
    }
}

package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class Return implements CalculationService {
    @Override
    public void transaction(FruitTransaction transaction) {
        int tempAmount = transaction.getQuantity()
                + Storage.STORAGE.get(transaction.getFruit());
        Storage.STORAGE.put(transaction.getFruit(), tempAmount);
    }
}

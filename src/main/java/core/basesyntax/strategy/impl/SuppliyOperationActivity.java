package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationActivity;

public class SuppliyOperationActivity implements OperationActivity {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int supplyQuantity = transaction.getQuantity();
        if (Storage.fruitTransactionsMap.containsKey(fruit)) {
            int storageQuantity = Storage.fruitTransactionsMap.get(fruit);
            Storage.fruitTransactionsMap.put(fruit, supplyQuantity + storageQuantity);
        } else {
            Storage.fruitTransactionsMap.put(fruit, supplyQuantity);
        }
    }
}

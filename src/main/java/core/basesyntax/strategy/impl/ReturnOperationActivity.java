package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationActivity;

public class ReturnOperationActivity implements OperationActivity {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();
        if (Storage.fruitTransactionsMap.containsKey(fruitName)) {
            int storageQuantity = Storage.fruitTransactionsMap.get(fruitName);
            Storage.fruitTransactionsMap.put(fruitName, quantity + storageQuantity);
        } else {
            Storage.fruitTransactionsMap.put(fruitName, quantity);
        }
    }
}

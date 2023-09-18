package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.storage.Storage;

public class OperationReturn implements Operation {
    @Override
    public void changeBalances(FruitTransaction transaction) {
        if (Storage.storage.containsKey(transaction.getFruit())) {
            Storage.storage.replace(transaction.getFruit(),
                    Storage.storage.get(transaction.getFruit())
                            + transaction.getQuantity());
        } else {
            Storage.storage.put(transaction.getFruit(),
                    transaction.getQuantity());
        }
    }
}

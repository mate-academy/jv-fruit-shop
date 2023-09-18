package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.storage.Storage;

public class OperationPurchase implements Operation {
    @Override
    public void changeBalances(FruitTransaction transaction) {
        Storage.storage.replace(transaction.getFruit(),
                Storage.storage.get(transaction.getFruit())
                        - transaction.getQuantity());
    }
}

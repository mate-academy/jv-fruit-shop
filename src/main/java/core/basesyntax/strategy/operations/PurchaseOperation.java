package core.basesyntax.strategy.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Operation;

public class PurchaseOperation implements Operation {
    @Override
    public void doOperation(FruitTransaction transaction) {
        int currentQuantity = Storage.getStorage().get(transaction.getFruit()) != null
                ? Storage.getStorage().get(transaction.getFruit()) : 0;
        if (currentQuantity < transaction.getQuantity()) {
            throw new RuntimeException("You can buy only "
                    + currentQuantity + " " + transaction.getFruit());
        }
        Storage.getStorage()
                .put(transaction.getFruit(), currentQuantity - transaction.getQuantity());
    }
}

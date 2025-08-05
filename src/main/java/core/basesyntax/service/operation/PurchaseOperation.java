package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitShop;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        int currentAmount = FruitShop.storage.getOrDefault(transaction.getFruit(), 0);
        if (currentAmount < transaction.getQuantity()) {
            throw new RuntimeException("The amount of fruit is less than needed");
        }

        FruitShop.storage.put(transaction.getFruit(), currentAmount - transaction.getQuantity());
    }
}

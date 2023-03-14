package core.basesyntax.operations;

import core.basesyntax.dao.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int DEFAULT_QUANTITY = 0;

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int amount = Storage.getOrDefault(fruitTransaction.getFruit(), DEFAULT_QUANTITY);
        int purchaseResult = amount - fruitTransaction.getQuantity();
        if (purchaseResult < 0) {
            throw new RuntimeException("Quantity of fruits less than you can buy");
        } else {
            Storage.put(fruitTransaction.getFruit(), purchaseResult);
        }
    }
}

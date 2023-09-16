package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getNameOfObject();
        int actualAmount = Storage.storage.get(fruitName);
        int purchaseAmount = fruitTransaction.getAmount();
        if (actualAmount < purchaseAmount) {
            throw new RuntimeException("Not enough product "
                    + fruitName
                    + ", actual amount is "
                    + actualAmount
                    + ", while "
                    + purchaseAmount
                    + " requested");
        }
        Storage.storage.put(fruitName,
                actualAmount - purchaseAmount);
    }
}

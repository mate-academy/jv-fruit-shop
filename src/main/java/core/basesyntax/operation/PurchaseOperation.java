package core.basesyntax.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getFruit() == null) {
            throw new RuntimeException("There are no "
                    + fruitTransaction.getFruit() + " int the storage");
        }
        int amountInStore = FruitStorage.getFruits().get(fruitTransaction.getFruit());
        int amountToBuy = fruitTransaction.getQuantity();
        if (amountInStore < amountToBuy) {
            throw new RuntimeException("Not enough fruit in the storage for this operation");
        }
        FruitStorage.getFruits().put(fruitTransaction.getFruit(), amountInStore - amountToBuy);
    }
}

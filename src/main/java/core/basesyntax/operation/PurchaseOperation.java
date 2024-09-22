package core.basesyntax.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int amountInStore = FruitStorage.fruitRepository.get(fruit);
        int amountToBuy = fruitTransaction.getQuantity();
        if (amountInStore < amountToBuy) {
            throw new RuntimeException("Not enough fruit in the storage for this operation");
        }
        FruitStorage.fruitRepository.put(fruit, amountInStore - amountToBuy);
    }
}

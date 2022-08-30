package core.basesyntax.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class PurchaseOperationService implements OperationHandler {
    @Override
    public void getResultOperation(FruitTransaction fruitTransaction) {
        Fruit currentFruit = fruitTransaction.getFruit();
        int currentRemainder = Storage.stogare.get(currentFruit);
        Storage.stogare.put(currentFruit, currentRemainder - fruitTransaction.getQuantity());
    }
}

package core.basesyntax.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class BalaceOperationHandler implements OperationHandler {

    @Override
    public void getResultOperation(FruitTransaction fruitTransaction) {
        Fruit currentFruit = fruitTransaction.getFruit();
        if (!Storage.stogare.containsKey(currentFruit.getName())) {
            Storage.stogare.put(currentFruit, fruitTransaction.getQuantity());
        } else {
            int currentRemainder = Storage.stogare.get(currentFruit);
            Storage.stogare.put(currentFruit, currentRemainder + fruitTransaction.getQuantity());
        }
    }
}

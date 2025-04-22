package core.basesyntax.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public interface OperationHandler {
    void get(FruitTransaction fruitTransaction);

    default void checkIfFruitExists(FruitTransaction fruitTransaction) {
        if (!Storage.fruitStorage.containsKey(fruitTransaction.getFruit())) {
            throw new IllegalArgumentException(
                    "Fruit does not exist in storage."
                            + " Must be initialized by Balance operation first");
        }
    }
}

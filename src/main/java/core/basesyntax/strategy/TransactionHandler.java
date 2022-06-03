package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void updateFruitQuantity(FruitTransaction transaction, int quantityOfFruitsInStorage);
}

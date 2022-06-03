package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionHandler {
    void dayResult(FruitTransaction transaction, int quantityOfFruitsInStorage);
}

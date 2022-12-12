package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    GeneralOperation get(FruitTransaction.Operation operation);
}

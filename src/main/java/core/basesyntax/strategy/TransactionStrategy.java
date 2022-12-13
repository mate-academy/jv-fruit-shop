package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface TransactionStrategy {
    HandlerAllOperation get(FruitTransaction.Operation operation);
}

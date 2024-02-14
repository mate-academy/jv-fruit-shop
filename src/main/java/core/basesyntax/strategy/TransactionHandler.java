package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategy;

public interface TransactionHandler {
    TransactionStrategy makeTransaction(FruitTransaction transaction);
}

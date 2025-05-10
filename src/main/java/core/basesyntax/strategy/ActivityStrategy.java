package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activity.TransactionHandler;

public interface ActivityStrategy {
    TransactionHandler get(FruitTransaction.Operation operation);
}

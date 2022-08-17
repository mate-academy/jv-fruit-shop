package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.FruitOperation;

public interface Strategy {
    FruitOperation get(FruitTransaction.Operation operation);
}

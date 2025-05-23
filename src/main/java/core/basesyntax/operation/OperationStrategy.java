package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationStrategy {
    void processTransaction(FruitTransaction transaction);
}


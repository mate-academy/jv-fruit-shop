package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.processing.OperationProcessing;

public interface OperationProcessingStrategy {
    OperationProcessing get(FruitTransaction.Operation operation);
}

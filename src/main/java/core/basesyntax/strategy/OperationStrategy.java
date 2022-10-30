package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationService;

public interface OperationStrategy {
    public OperationService get(Operation operation);
}

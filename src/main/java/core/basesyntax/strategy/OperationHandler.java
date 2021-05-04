package core.basesyntax.strategy;

import core.basesyntax.dto.Operation;
import core.basesyntax.exceptions.AlreadyHaveItException;

public interface OperationHandler {
    void handle(Operation operation) throws AlreadyHaveItException;
}

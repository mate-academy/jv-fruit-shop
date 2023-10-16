package core.basesyntax.service;

import core.basesyntax.model.LineInformation;
import core.basesyntax.service.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(LineInformation operation);
}

package core.basesyntax.service;

import core.basesyntax.service.handler.OperationHandler;
import java.util.Optional;

public interface OperationStrategy {
    Optional<OperationHandler> get(String operation);
}

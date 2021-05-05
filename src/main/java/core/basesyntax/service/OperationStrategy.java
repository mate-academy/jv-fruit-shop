package core.basesyntax.service;

import core.basesyntax.service.handler.OperationHandler;
import java.util.Optional;

public interface OperationStrategy {
    OperationHandler get(String operation);
}

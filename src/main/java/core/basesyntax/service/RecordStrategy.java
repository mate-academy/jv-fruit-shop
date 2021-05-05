package core.basesyntax.service;

import core.basesyntax.service.handler.OperationHandler;
import java.util.Optional;

public interface RecordStrategy {
    Optional<OperationHandler> get(String action);
}

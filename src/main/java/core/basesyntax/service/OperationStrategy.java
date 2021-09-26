package core.basesyntax.service;

import core.basesyntax.model.*;
import core.basesyntax.service.strategy.*;

public interface OperationStrategy {
    OperationHandler get(FruitRecord.Operation operation);
}

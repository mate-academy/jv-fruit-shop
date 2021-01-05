package core.basesyntax.service.interfaces;

import core.basesyntax.service.operations.Operation;
import java.util.Map;

public interface CreateStrategy {
    Map<String, Operation> createStrategy();
}

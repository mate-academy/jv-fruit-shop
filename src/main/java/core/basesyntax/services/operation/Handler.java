package core.basesyntax.services.operation;

import core.basesyntax.model.Operation;
import java.util.Map;

public interface Handler {
    int getAmount(Operation operation, Map<String, Integer> fruitsStorage);
}

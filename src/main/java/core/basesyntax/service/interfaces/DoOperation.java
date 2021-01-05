package core.basesyntax.service.interfaces;

import core.basesyntax.service.operations.Operation;
import java.util.Map;

public interface DoOperation {
    void doOperation(Map<String, Integer> shop, String[] record, Map<String, Operation> strategy);
}

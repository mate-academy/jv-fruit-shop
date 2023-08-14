package core.basesyntax.service.strategy;

import core.basesyntax.service.counter.OperationType;
import java.util.Map;

public interface CountStrategy {

    int OPERATION_INDEX = 0;
    OperationType getOperationType(Map<String, OperationType> operationStrategyMap, String string);
}

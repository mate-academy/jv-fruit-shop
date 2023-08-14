package core.basesyntax.service.strategy;

import core.basesyntax.service.counter.OperationType;
import java.util.Map;

public class CountStrategyImpl implements CountStrategy {
    @Override
    public OperationType getOperationType(Map<String, OperationType> operationStrategyMap,
                                          String string) {
        String[] splitStringArray = string.split(",");
        return operationStrategyMap.get(splitStringArray[OPERATION_INDEX]);
    }
}

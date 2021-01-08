package core.basesyntax.strategy;

import core.basesyntax.model.Operations;
import java.util.Map;
import java.util.Optional;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operations, OperationHandler> operationsMap;

    public OperationStrategyImpl(Map<Operations, OperationHandler> activitiesMap) {
        this.operationsMap = activitiesMap;
    }

    @Override
    public OperationHandler get(Operations typeOfActivity) {
        Optional<OperationHandler> activitiesHandler =
                Optional.of(operationsMap.get(typeOfActivity));
        return activitiesHandler.orElseThrow(RuntimeException::new);
    }
}

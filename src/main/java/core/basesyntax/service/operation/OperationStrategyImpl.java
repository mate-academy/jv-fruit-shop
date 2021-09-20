package core.basesyntax.service.operation;

import core.basesyntax.model.FruitRecord;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitRecord.Type, OperationHandler> operationTypesMap;

    public OperationStrategyImpl(Map<FruitRecord.Type, OperationHandler> operationTypesMap) {
        this.operationTypesMap = operationTypesMap;
    }

    @Override
    public OperationHandler get(FruitRecord.Type typeOfOperation) {
        return operationTypesMap.get(typeOfOperation);
    }
}

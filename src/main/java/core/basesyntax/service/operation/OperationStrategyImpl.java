package core.basesyntax.service.operation;

import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitRecordDto.Type, OperationHandler> operationTypesMap;

    public OperationStrategyImpl(Map<FruitRecordDto.Type, OperationHandler> operationTypesMap) {
        this.operationTypesMap = operationTypesMap;
    }

    @Override
    public OperationHandler get(FruitRecordDto.Type typeOfOperation) {
        return operationTypesMap.get(typeOfOperation);
    }
}

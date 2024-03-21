package strategy;

import dto.FruitTransactionDto;
import java.util.Map;
import service.operations.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> strategyMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public OperationHandler get(FruitTransactionDto dto) {
        Operation operation = Operation.fromString(dto.operation());
        return strategyMap.get(operation);
    }
}

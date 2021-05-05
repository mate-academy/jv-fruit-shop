package core.basesyntax.fruitoperationstrategy;

import core.basesyntax.operations.Operation;
import core.basesyntax.service.operationwithdata.FruitOperationService;
import java.util.Map;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<Operation, FruitOperationService> strategyMap;

    public FruitStrategyImpl(Map<Operation, FruitOperationService> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public FruitOperationService get(Operation operation) {
        return strategyMap.get(operation);
    }
}

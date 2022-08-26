package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.CalculateOperation;
import java.util.Map;

public class StrategyImpl implements Strategy{
    private final Map<FruitOperation.Operation, CalculateOperation> fruitOperation;

    public StrategyImpl(Map<FruitOperation.Operation, CalculateOperation> fruitOperation) {
        this.fruitOperation = fruitOperation;
    }

    @Override
    public CalculateOperation get(FruitOperation.Operation operation) {
        return fruitOperation.get(operation);
    }
}

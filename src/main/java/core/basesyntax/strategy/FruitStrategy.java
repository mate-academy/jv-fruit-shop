package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public class FruitStrategy {
    private final Map<Operation, OperationHandler> map;

    public FruitStrategy(Map<Operation, OperationHandler> operationStrategyMap) {
        this.map = operationStrategyMap;
    }

    public void processData(List<FruitTransaction> transactions) {
        OperationHandler handler;
        for (FruitTransaction transaction : transactions) {
            handler = map.get(transaction.operation());
            handler.apply(transaction);
        }
    }
}

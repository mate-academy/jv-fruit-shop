package core.basesyntax.strategyhandler;

import core.basesyntax.storage.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class StrategyHandlerImpl implements StrategyHandler {
    public OperationHandler strategyHandler(FruitTransaction.Operation operation,
                            Map<FruitTransaction.Operation, OperationHandler> strategyMap) {
        return strategyMap.get(operation);
    }
}

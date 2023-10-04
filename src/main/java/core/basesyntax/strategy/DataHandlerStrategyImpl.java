package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.DataHandler;
import java.util.Map;

public class DataHandlerStrategyImpl implements DataHandlerStrategy {
    private final Map<FruitTransaction.Operation, DataHandler> operationDataHandlerMap;

    public DataHandlerStrategyImpl(
            Map<FruitTransaction.Operation, DataHandler> operationDataHandlerMap) {
        this.operationDataHandlerMap = operationDataHandlerMap;
    }

    @Override
    public DataHandler getHandler(FruitTransaction.Operation operation) {
        return operationDataHandlerMap.get(operation);
    }
}

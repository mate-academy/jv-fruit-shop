package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.DataHandler;
import java.util.Map;

public class DataHandlerStrategyImpl implements DataHandlerStrategy {
    // створили мапу з операцією і відповідному їй хендлеру
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

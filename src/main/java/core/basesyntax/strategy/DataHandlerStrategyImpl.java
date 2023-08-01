package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.DataHandler;
import java.util.Map;

public class DataHandlerStrategyImpl implements DataHandlerStrategy {
    // створили мапу з операцією і відповідному їй хендлеру
    private Map<FruitTransaction.Operation, DataHandler> activityDataHandlerMap;

    public DataHandlerStrategyImpl(
            Map<FruitTransaction.Operation, DataHandler> activityDataHandlerMap) {
        this.activityDataHandlerMap = activityDataHandlerMap;
    }

    @Override
    public DataHandler getHandler(FruitTransaction.Operation operation) {
        return activityDataHandlerMap.get(operation);
    }
}

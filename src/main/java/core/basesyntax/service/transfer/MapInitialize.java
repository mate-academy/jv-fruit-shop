package core.basesyntax.service.transfer;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.operation.BalanceOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.DecreaseOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.IncreaseOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class MapInitialize {

    public Map<String, OperationHandler> initializeMap() {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitRecord.OperationType.BALANCE.getType(),
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitRecord.OperationType.PURCHASE.getType(),
                new DecreaseOperationHandlerImpl());
        operationHandlerMap.put(FruitRecord.OperationType.SUPPLY.getType(),
                new IncreaseOperationHandlerImpl());
        operationHandlerMap.put(FruitRecord.OperationType.RETURN.getType(),
                new IncreaseOperationHandlerImpl());
        Storage.operationHandlerMap = operationHandlerMap;
        return Storage.operationHandlerMap;
    }
}

package core.basesyntax.service.fruitservice;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.strategy.operation.BalanceOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.DecreaseOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.IncreaseOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class MapInitialize {

    public Map<String, OperationHandler> initializeMap() {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitRecordDto.OperationType.BALANCE.getType(),
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitRecordDto.OperationType.PURCHASE.getType(),
                new DecreaseOperationHandlerImpl());
        operationHandlerMap.put(FruitRecordDto.OperationType.SUPPLY.getType(),
                new IncreaseOperationHandlerImpl());
        operationHandlerMap.put(FruitRecordDto.OperationType.RETURN.getType(),
                new IncreaseOperationHandlerImpl());
        Storage.operationHandlerMap = operationHandlerMap;
        return Storage.operationHandlerMap;
    }
}

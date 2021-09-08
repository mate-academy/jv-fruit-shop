package core.basesyntax.db;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.strategy.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.DecreaseAmountOperationHandlerImpl;
import core.basesyntax.strategy.IncreaseAmountOperationHandlerImpl;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();
    private static final Map<FruitRecord.Operation, OperationHandler> handlerMap;

    static {
        handlerMap = new HashMap<>();
        handlerMap.put(FruitRecord.Operation.PURCHASE, new DecreaseAmountOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.SUPPLY, new IncreaseAmountOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.BALANCE, new BalanceOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.RETURN, new IncreaseAmountOperationHandlerImpl());
    }

    public static Map<String, Integer> getStorage() {
        return storage;
    }

    public static Map<FruitRecord.Operation, OperationHandler> getHandlerMap() {
        return handlerMap;
    }
}

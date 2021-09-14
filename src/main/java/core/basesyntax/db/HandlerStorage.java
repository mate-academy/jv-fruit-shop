package core.basesyntax.db;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.strategy.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.DecreaseAmountOperationHandlerImpl;
import core.basesyntax.strategy.IncreaseAmountOperationHandlerImpl;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class HandlerStorage {
    private static final Map<FruitRecord.Operation, OperationHandler> handlerMap;

    static {
        handlerMap = new HashMap<>();
        handlerMap.put(FruitRecord.Operation.PURCHASE, new DecreaseAmountOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.SUPPLY, new IncreaseAmountOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.BALANCE, new BalanceOperationHandlerImpl());
        handlerMap.put(FruitRecord.Operation.RETURN, new IncreaseAmountOperationHandlerImpl());
    }

    public static Map<FruitRecord.Operation, OperationHandler> getHandlerMap() {
        return handlerMap;
    }

    public static FruitRecord.Operation getOperationByFirstLetter(char symbol) {
        switch (symbol) {
            case 'b': return FruitRecord.Operation.BALANCE;
            case 'p': return FruitRecord.Operation.PURCHASE;
            case 'r': return FruitRecord.Operation.RETURN;
            case 's': return FruitRecord.Operation.SUPPLY;
            default: throw new NoSuchElementException("There isn't such operation for fruit shop.");
        }
    }

    public static OperationHandler getHandlerByLetter(char symbol) {
        return handlerMap.get(getOperationByFirstLetter(symbol));
    }
}

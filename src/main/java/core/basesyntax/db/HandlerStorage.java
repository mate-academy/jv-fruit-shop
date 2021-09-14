package core.basesyntax.db;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;
import java.util.NoSuchElementException;

public class HandlerStorage {
    private Map<FruitRecord.Operation, OperationHandler> handlerMap;

    public HandlerStorage(Map<FruitRecord.Operation, OperationHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public Map<FruitRecord.Operation, OperationHandler> getHandlerMap() {
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
}

package core.basesyntax.db;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.Map;

public class HandlerStorage {
    private final Map<FruitRecord.Operation, OperationHandler> handlerStorage;

    public HandlerStorage(Map<FruitRecord.Operation, OperationHandler> handlerStorage) {
        this.handlerStorage = handlerStorage;
    }

    public Map<FruitRecord.Operation, OperationHandler> getHandlerStorage() {
        return handlerStorage;
    }

    public static FruitRecord.Operation getOperation(char operation) {
        switch (operation) {
            case 'b': return FruitRecord.Operation.BALANCE;
            case 's': return FruitRecord.Operation.SUPPLY;
            case 'p': return FruitRecord.Operation.PURCHASE;
            case 'r': return FruitRecord.Operation.RETURN;
            default: throw new RuntimeException("Operation is invalid!");
        }
    }
}

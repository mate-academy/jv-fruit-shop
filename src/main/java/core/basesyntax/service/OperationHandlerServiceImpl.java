package core.basesyntax.service;

import core.basesyntax.db.HandlerStorage;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerServiceImpl implements OperationHandlerService {
    public void changeAmount(FruitRecord record) {
        char symbol = record.getOperation()
                .name()
                .toLowerCase()
                .charAt(0);
        OperationHandler handler = HandlerStorage.getHandlerByLetter(symbol);
        handler.getChangedAmount(record);
    }
}

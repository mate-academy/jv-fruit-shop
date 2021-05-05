package core.basesyntax.service.fruitservice;

import core.basesyntax.model.Operation;
import core.basesyntax.service.handlers.RecordHandler;
import java.util.Map;

public class FruitRecordStrategyImpl implements FruitRecordStrategy {
    private final Map<Operation, RecordHandler> fruitOperationHandler;

    public FruitRecordStrategyImpl(Map<Operation, RecordHandler> fruitOperationHandler) {
        this.fruitOperationHandler = fruitOperationHandler;
    }

    @Override
    public RecordHandler get(Operation type) {
        return fruitOperationHandler.get(type);
    }
}

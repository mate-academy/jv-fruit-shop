package core.basesyntax.service.fruitservice;

import core.basesyntax.model.Operation;
import core.basesyntax.service.handlers.RecordHandler;

public interface FruitRecordStrategy {
    RecordHandler get(Operation type);
}

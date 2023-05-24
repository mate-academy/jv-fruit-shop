package core.basesyntax.strategy;

import core.basesyntax.model.fruit.Record;
import core.basesyntax.storage.Storage;
import core.basesyntax.validation.IntegerValidator;
import core.basesyntax.validation.QuantityValidator;

public abstract class BaseOperationHandler implements OperationHandler {
    protected final IntegerValidator validator = new QuantityValidator();

    protected boolean updateFruitMap(Record record, Integer currentValue) {
        if (currentValue == null) {
            Storage.fruitMap.put(record.getFruit(), record.getQuantity());
            return true;
        }
        return false;
    }
}

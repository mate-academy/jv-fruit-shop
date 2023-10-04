package core.basesyntax.strategy.impl;

import core.basesyntax.model.fruit.Record;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.BaseOperationHandler;

public class ReturnHandler extends BaseOperationHandler {
    @Override
    public void perform(Record record) {
        Integer currentValue = Storage.fruitMap.get(record.getFruit());
        if (updateFruitMap(record, currentValue)) {
            return;
        }
        int updatedValue = validator.check(currentValue + record.getQuantity());
        Storage.fruitMap.put(record.getFruit(), updatedValue);
    }
}

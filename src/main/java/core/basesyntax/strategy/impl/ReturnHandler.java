package core.basesyntax.strategy.impl;

import core.basesyntax.model.fruit.Record;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.BaseOperationHandler;

public class ReturnHandler extends BaseOperationHandler {
    @Override
    public void perform(Record record) {
        int updatedValue = validator.check(
                Storage.fruitMap.get(record.getFruit()) + record.getQuantity());
        Storage.fruitMap.put(record.getFruit(), updatedValue);
    }
}

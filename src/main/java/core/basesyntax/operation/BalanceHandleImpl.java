package core.basesyntax.operation;

import core.basesyntax.db.FruitDataBase;
import core.basesyntax.model.FruitRecordDto;

public class BalanceHandleImpl implements OperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecord) {
        FruitDataBase.storage.put(fruitRecord.getFruit(), fruitRecord.getQuantity());
        return fruitRecord.getQuantity();
    }
}

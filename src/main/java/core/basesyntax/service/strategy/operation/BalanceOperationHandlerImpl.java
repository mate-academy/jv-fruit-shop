package core.basesyntax.service.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitRecordDto;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public int getAmount(FruitRecordDto fruitRecord) {
        Storage.fruitStorage.put(fruitRecord.getFruitName(), fruitRecord.getAmount());
        return fruitRecord.getAmount();
    }
}

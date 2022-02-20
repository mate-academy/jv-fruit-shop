package core.basesyntax.service.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public class IncreaseOperationHandlerImpl implements OperationHandler {

    @Override
    public int getAmount(FruitRecordDto fruitRecord) {
        for (Map.Entry<Fruit, Integer> fruitRecordEntry : Storage.fruitStorage.entrySet()) {
            if (fruitRecordEntry.getKey().equals(fruitRecord.getFruitName())) {
                return fruitRecordEntry.getValue() + fruitRecord.getAmount();
            }
        }
        throw new RuntimeException("No such operation");
    }
}

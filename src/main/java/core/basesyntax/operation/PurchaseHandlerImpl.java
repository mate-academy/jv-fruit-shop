package core.basesyntax.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public class PurchaseHandlerImpl implements Handler {
    @Override
    public int changeAmount(FruitRecordDto fruitRecord, Map<Fruit, Integer> storage) {
        for (Map.Entry<Fruit, Integer> fruitInteger : storage.entrySet()) {
            if (fruitInteger.getKey().equals(fruitRecord.getFruit())) {
                return fruitInteger.getValue() - fruitRecord.getQuantity();
            }
        }
        throw new RuntimeException("Operation is not valid");
    }
}

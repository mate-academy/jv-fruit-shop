package core.basesyntax.operation;

import core.basesyntax.db.FruitDataBase;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import java.util.Map;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int apply(FruitRecordDto fruitRecord) {
        int newAmount = 0;
        for (Map.Entry<Fruit, Integer> fruitInteger : FruitDataBase.storage.entrySet()) {
            if (fruitInteger.getKey().equals(fruitRecord.getFruit())) {
                newAmount = fruitInteger.getValue() - fruitRecord.getQuantity();
            }
        }
        FruitDataBase.storage.put(fruitRecord.getFruit(), newAmount);
        return newAmount;
    }
}

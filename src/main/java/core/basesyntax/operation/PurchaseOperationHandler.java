package core.basesyntax.operation;

import core.basesyntax.model.FruitType;
import java.util.Map;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void setDataInStorage(Map<FruitType, Integer> totalFruitAmount,
                                 FruitType fruit, int amount) {
        if (totalFruitAmount.get(fruit) < amount) {
            throw new RuntimeException("Can't make purchase operation! "
                    + "Amount for buying bigger than fruit balance!");
        }
        totalFruitAmount.put(fruit, totalFruitAmount.get(fruit) - amount);
    }
}

package core.basesyntax.operation;

import core.basesyntax.model.FruitType;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void setDataInStorage(Map<FruitType, Integer> totalFruitAmount,
                                 FruitType fruit, int amount) {
        totalFruitAmount.put(fruit, totalFruitAmount.get(fruit) + amount);
    }
}

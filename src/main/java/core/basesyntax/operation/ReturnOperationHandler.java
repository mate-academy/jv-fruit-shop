package core.basesyntax.operation;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void setDataInStorage(Map<Fruit, Integer> totalFruitAmount,
                                 Fruit fruit, int amount) {
        totalFruitAmount.put(fruit, totalFruitAmount.get(fruit) + amount);
    }
}

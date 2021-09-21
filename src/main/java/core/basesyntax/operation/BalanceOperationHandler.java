package core.basesyntax.operation;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void setDataInStorage(Map<Fruit, Integer> totalFruitAmount,
                                 Fruit fruit, int amount) {
        totalFruitAmount.put(fruit, amount);
    }
}

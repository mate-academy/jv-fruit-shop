package core.basesyntax.operation;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface OperationHandler {
    void setDataInStorage(Map<Fruit, Integer> totalFruitAmount, Fruit fruit, int amount);
}

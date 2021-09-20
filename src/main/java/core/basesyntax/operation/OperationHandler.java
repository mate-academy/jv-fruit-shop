package core.basesyntax.operation;

import core.basesyntax.model.FruitType;
import java.util.Map;

public interface OperationHandler {
    void setDataInStorage(Map<FruitType, Integer> totalFruitAmount, FruitType fruit, int amount);
}

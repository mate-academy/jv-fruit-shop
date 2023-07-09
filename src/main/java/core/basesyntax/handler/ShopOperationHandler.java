package core.basesyntax.handler;

import core.basesyntax.model.Fruit;
import core.basesyntax.utility.FruitType;
import java.util.Map;

public interface ShopOperationHandler {
    public void doOperation(Map<FruitType, Fruit> fruitMap, String fruitName, String quantity);
}

package core.basesyntax.handler;

import core.basesyntax.model.Fruit;

import java.util.Map;

public interface ShopOperationHandler {
    public void doOperation(Map<String, Fruit> fruitMap, String fruitName, String quantity);
}

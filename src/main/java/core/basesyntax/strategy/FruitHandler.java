package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitHandler {
    void transactionHandler(
            Map<String, Fruit> fruitsData,
            String fruitName,
            int fruitQuantity
    );
}

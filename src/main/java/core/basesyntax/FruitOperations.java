package core.basesyntax;

import java.util.Map;

public interface FruitOperations {
    void balanceFruit(FruitListOperation operation, Map<String, Fruit> fruits);

    void supplyFruit(FruitListOperation operation, Map<String, Fruit> fruits);

    void purchaseFruit(FruitListOperation operation, Map<String, Fruit> fruits);

    void returnFruit(FruitListOperation operation, Map<String, Fruit> fruits);
}

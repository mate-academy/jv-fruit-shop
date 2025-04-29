package core.basesyntax.strategy;

import java.util.Map;

public class ReturnOperation implements FruitOperationStrategy {

    @Override
    public void execute(Map<String, Integer> fruitQuantity, String fruit, int quantity) {
        fruitQuantity.put(fruit, fruitQuantity.get(fruit) + quantity);
    }
}

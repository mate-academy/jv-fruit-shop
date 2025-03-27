package core.basesyntax;

import java.util.Map;

public class Balance implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
        fruitShop.put(fruit, quantity);
    }
}

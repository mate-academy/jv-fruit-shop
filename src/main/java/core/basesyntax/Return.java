package core.basesyntax;

import java.util.Map;

public class Return implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
        int currentQuantity = fruitShop.getOrDefault(fruit, 0);
        fruitShop.put(fruit, currentQuantity + quantity);
    }
}

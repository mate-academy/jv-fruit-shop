package core.basesyntax;

import java.util.Map;

public class Purchase implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
        int currentQuantity = fruitShop.getOrDefault(fruit, 0);
        if (currentQuantity - quantity < 0) {
            throw new RuntimeException("Недостаточно товара для покупки " + fruit);
        }
        fruitShop.put(fruit, currentQuantity - quantity);
    }
}

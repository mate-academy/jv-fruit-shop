package core.basesyntax;

import java.util.Map;

public class Supply implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
        int currentQuantity = fruitShop.getOrDefault(fruit, 0);
        if (currentQuantity - quantity < 0) {
            throw new RuntimeException("Недостаточно товара для продажи " + fruit);
        }
        fruitShop.put(fruit, currentQuantity - quantity);
    }
}

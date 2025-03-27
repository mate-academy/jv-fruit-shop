package core.basesyntax;

import java.util.Map;

interface OperationStrategy {
    void execute(Map<String, Integer> fruitShop, String fruit, int quantity);
}

class Balance implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
        fruitShop.put(fruit, quantity);
    }
}

class Supply implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
        int currentQuantity = fruitShop.getOrDefault(fruit, 0);
        if (currentQuantity - quantity < 0) {
            throw new RuntimeException("Недостаточно товара для продажи " + fruit);
        }
        fruitShop.put(fruit, currentQuantity - quantity);
    }
}

class Purchase implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
        int currentQuantity = fruitShop.getOrDefault(fruit, 0);
        if (currentQuantity - quantity < 0) {
            throw new RuntimeException("Недостаточно товара для покупки " + fruit);
        }
        fruitShop.put(fruit, currentQuantity - quantity);
    }
}

class Return implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> fruitShop, String fruit, int quantity) {
        int currentQuantity = fruitShop.getOrDefault(fruit, 0);
        fruitShop.put(fruit, currentQuantity + quantity);
    }
}


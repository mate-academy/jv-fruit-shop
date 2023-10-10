package fruit.shop.strategy;

import fruit.shop.model.Fruits;

public interface OperationStrategy {
    OperationHandler get(String type);
}

package strategy;

import model.FruitTransaction;

public interface FruitStrategy {
     void addToInventoryByOperationType(FruitTransaction fruitTransaction);
     boolean isApplicable(FruitTransaction fruitTransaction);
}

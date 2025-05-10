package fruitshop.strategy;

import fruitshop.model.FruitTransaction;

public interface OperationStrategy {
    public void executeOperation(FruitTransaction fruitTransaction);

}

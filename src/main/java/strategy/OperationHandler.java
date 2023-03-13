package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void operation(FruitTransaction fruitTransaction);
}

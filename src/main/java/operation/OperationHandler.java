package operation;

import model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction fruitTransaction);
}

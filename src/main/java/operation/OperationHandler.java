package operation;

import model.FruitTransaction;

public interface OperationHandler {
    void accept(FruitTransaction fruitTransaction);
}

package operation;

import model.FruitTransaction;

public interface OperationHandler {
    void perform(FruitTransaction fruitTransaction);
}

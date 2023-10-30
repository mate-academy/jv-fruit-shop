package operation;

import model.FruitTransaction;
import model.Operation;

public interface OperationHandler {
    void perform(FruitTransaction fruitTransaction);
}

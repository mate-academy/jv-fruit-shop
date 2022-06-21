package Strategy;

import model.FruitTransaction;
import service.FruitHandler;

public interface OperationStrategy {
    FruitHandler get (FruitTransaction.Operation operation);
}

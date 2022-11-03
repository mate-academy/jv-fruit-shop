package strategies;

import models.FruitTransaction;
import services.operationhandler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}

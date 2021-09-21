package myFruitShop.Service;

import myFruitShop.Service.Operations.OperationHandler;
import myFruitShop.model.OperationType;

public interface OperationStrategy {
    OperationHandler get (OperationType operation);
}

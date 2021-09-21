package myFruitShop.Service;

import myFruitShop.Service.Operations.OperationHandler;
import myFruitShop.model.OperationType;
import myFruitShop.model.TransactionDto;

public interface OperationStrategy {
    OperationHandler get (OperationType operation);
}

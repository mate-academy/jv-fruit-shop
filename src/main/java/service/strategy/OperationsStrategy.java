package service.strategy;

import model.FruitTransaction;
import service.operations.OperationsHandler;

public interface OperationsStrategy {
    OperationsHandler get(FruitTransaction.Operation operation);
}

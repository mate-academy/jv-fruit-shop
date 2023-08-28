package service;

import model.FruitTransaction;
import service.storage.PerformingOperation;

public interface OperationStrategy {
    PerformingOperation get(FruitTransaction.Operation code);
}

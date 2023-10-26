package service;

import model.FruitTransaction;
import strategy.Operating;

public interface OperationStrategy {
    Operating findRightStrategy(FruitTransaction.Operation operation);
}

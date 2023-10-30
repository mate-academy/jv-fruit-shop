package service;

import model.Operation;
import strategy.Operating;

public interface OperationStrategy {
    Operating findRightStrategy(Operation operation);
}

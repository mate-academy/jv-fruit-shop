package strategy;

import model.Fruit;
import service.OperationHandler;

public interface OperationStrategy {
    void addOperation(String type, OperationHandler operation);

    void operationCheck(String type, Fruit key, String value);
}

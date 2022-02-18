package fruitshop.service;

import fruitshop.model.Operation;

public interface OperationStrategy {
    void chooseStrategy(Operation operation, String fruit, Integer quantity);
}

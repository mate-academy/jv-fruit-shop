package strategy;

import service.impl.FruitServiceImpl;

public interface OperationHandler {
    void apply(String name, int quantity);

    void handle(FruitServiceImpl.Transaction transaction);
}

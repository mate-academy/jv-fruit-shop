package strategy;

import fruitscontent.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}

package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void handle(FruitTransaction transaction);
}

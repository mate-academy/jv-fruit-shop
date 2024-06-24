package strategy;

import model.FruitTransaction;

public interface OperationHandler {
    void applyOperation(FruitTransaction transaction);
}

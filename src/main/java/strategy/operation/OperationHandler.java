package strategy.operation;

import model.FruitTransaction;

public interface OperationHandler {
    void execute(FruitTransaction transaction);
}
